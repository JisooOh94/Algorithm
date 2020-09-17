package medium.Out_of_Boundary_Paths;

import org.junit.Test;

/**
 * Runtime : 14ms(24.41%)
 * Memory : 41.2mb(8.03%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] params = new int[]{2, 2, 2, 0, 0};
//		int[] params = new int[]{1, 3, 3, 0, 1};
//		int[] params = new int[]{8,50,23,5,26};
		int[] params = new int[]{36,5,50,15,3};
		System.out.println(findPaths(params[0],params[1],params[2],params[3],params[4]));
	}
	private static final int MOD = (int)Math.pow(10,9) + 7;
	private int[][] MOVE = new int[][]{
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	private boolean isOutBound(int y, int x, int height, int width) {
		return y < 0 || height == y || x < 0 || width == x;
	}
	private long recursion(int curY, int curX, int height, int width, int leftMoveCnt, Long[][][] record) {
		if(leftMoveCnt == 0) return isOutBound(curY, curX, height, width) ? 1 : 0;
		else if(isOutBound(curY, curX, height, width)) return 0;
		else if(record[curY][curX][leftMoveCnt] != null) return record[curY][curX][leftMoveCnt];

		long totalWay = 0;
		for(int i = 0; i < 4; i++) {
			totalWay += recursion(curY + MOVE[i][0], curX + MOVE[i][1], height, width, leftMoveCnt - 1, record) % MOD;
		}

		totalWay %= MOD;
		record[curY][curX][leftMoveCnt] = totalWay;
		return totalWay;
	}
	public int findPaths(int height, int width, int moveCnt, int startY, int startX) {
		long totalWaySum = 0;
		Long[][][] record = new Long[height][width][moveCnt + 1];
		for(int i = 1; i <= moveCnt; i++) {
			totalWaySum += recursion(startY, startX, height, width, i, record);
		}
		return (int)(totalWaySum % MOD);
	}
}
