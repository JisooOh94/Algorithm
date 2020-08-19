package medium.Android_Unlock_Patterns;

import org.junit.Test;

/**
 * Runtime : 43ms(40.17%)
 * Memory : 35.8mb(98.17%)
 */
public class Solution {
	private static final int[][] pos = new int[][]{
			{0, 0},
			{0, 1},
			{0, 2},
			{1, 0},
			{1, 1},
			{1, 2},
			{2, 0},
			{2, 1},
			{2, 2}
	};

	@Test
	public void execute() {
		int m = 1; int n = 4;
		System.out.println(numberOfPatterns(m, n));
	}

	private boolean isNotOverlapped(int idx_1, int idx_2, boolean[] visited) {
		int xGap = Math.abs(pos[idx_1][1] - pos[idx_2][1]);
		int yGap = Math.abs(pos[idx_1][0] - pos[idx_2][0]);
		return (xGap < 2 &&  yGap< 2) || xGap + yGap == 3 || visited[Math.min(idx_1, idx_2) + Math.abs(idx_1 - idx_2) / 2];
	}

	private int recursion(int curIdx, int curCnt, boolean[] visited, int min, int max) {
		if(curCnt >= max) return 1;
		int patCnt = 0;

		for(int i = 0; i < 9; i++) {
			if(!visited[i] && (isNotOverlapped(curIdx, i, visited))) {
				visited[i] = true;
				patCnt += recursion(i, curCnt + 1, visited, min, max);
				visited[i] = false;
			}
		}

		return min <= curCnt ? patCnt + 1 : patCnt;
	}
	public int numberOfPatterns(int m, int n) {
		boolean[] visited = new boolean[9];
		int patCnt = 0;
		for(int i = 0; i < 9; i++) {
			visited[i] = true;
			patCnt += recursion(i, 1, visited, m, n);
			visited[i] = false;
		}
		return patCnt;
	}
}
