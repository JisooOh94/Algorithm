package medium.Knight_Dialer;

import org.junit.Test;

/**
 * Runtime : 162ms(27.88%)
 * Memory : 43.5mb(39.77%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 3131;
		System.out.println(knightDialer(n));
	}
	private static final long MOD = (long)Math.pow(10, 9) + 7;
	private static final int[][] MOVEMENT = new int[][]{
			{1, 2},
			{1, -2},
			{-1, 2},
			{-1, -2},
			{2, 1},
			{2, -1},
			{-2, 1},
			{-2, -1}
	};

	private static final int[][] INVALID_POS = new int[][]{
			{3, 0},
			{3, 2}
	};

	private boolean isValidPos(int y, int x) {
		return 0 <= y && y < 4 && 0 <= x && x < 3 && !(x == INVALID_POS[0][1] && y == INVALID_POS[0][0] || x == INVALID_POS[1][1] && y == INVALID_POS[1][0]);
	}

	private long recursion(int moveCnt, int x, int y, Long[][][] record) {
		if(moveCnt == 0) return 1;
		else if(record[y][x][moveCnt] != null) return record[y][x][moveCnt];

		long totalCnt = 0;
		for(int[] movement : MOVEMENT) {
			int newY = y + movement[0];
			int newX = x + movement[1];

			if(isValidPos(newY, newX)) {
				totalCnt += recursion(moveCnt - 1, newX, newY, record);
				totalCnt %= MOD;
			}
		}

		record[y][x][moveCnt] = totalCnt;
		return totalCnt;
	}

	public int knightDialer(int n) {
		Long[][][] record = new Long[4][3][n];
		long totalCnt = 0;
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				totalCnt += recursion(n - 1, x, y, record);
			}
		}
		return (int)((totalCnt + recursion(n - 1, 1, 3, record)) % MOD);
	}
}
