package hard.Unique_Paths_III;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37mb(30.00%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] grid = new int[][]{
//				{1, 0, 0, 0},
//				{0, 0, 0, 0},
//				{0, 0, 2, -1}
//		};
		int[][] grid = new int[][]{
				{1,0,0,0},{0,0,0,0},{0,0,0,2}
		};
//		int[][] grid = new int[][]{
//				{1, 0},
//				{0, 2}
//		};
		System.out.println(uniquePathsIII(grid));
	}

	private static final int[][] MOVE = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	private static final int OBSTACLE = -1;
	private static final int START = 1;
	private static final int TARGET = 2;

	private int recursion(int curX, int curY, int coveredCnt, int totalCnt, int[][] grid, boolean[][] visited) {
		if (grid[curY][curX] == TARGET && coveredCnt != totalCnt) {
			return 0;
		}
		else if (grid[curY][curX] == TARGET && coveredCnt == totalCnt) {
			return 1;
		}

		int waySum = 0;
		for (int i = 0; i < 4; i++) {
			int nextX = curX + MOVE[i][0];
			int nextY = curY + MOVE[i][1];
			if (0 <= nextX && nextX < grid[0].length && 0 <= nextY && nextY < grid.length && grid[nextY][nextX] != OBSTACLE && !visited[nextY][nextX]) {
				visited[nextY][nextX] = true;
				waySum += recursion(nextX, nextY, coveredCnt + 1, totalCnt, grid, visited);
				visited[nextY][nextX] = false;
			}
		}
		return waySum;
	}

	public int uniquePathsIII(int[][] grid) {
		int totalCnt = 0;
		int startX, startY;
		startX = startY = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				if (grid[y][x] == 0 || grid[y][x] == TARGET) totalCnt++;
				else if (grid[y][x] == START) {
					startX = x;
					startY = y;
					visited[y][x] = true;
				}
			}
		}

		return recursion(startX, startY, 0, totalCnt, grid, visited);
	}
}