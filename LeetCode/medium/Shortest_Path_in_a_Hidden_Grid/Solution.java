package medium.Shortest_Path_in_a_Hidden_Grid;

import org.junit.Test;

/**
 * Failed
 */
public class Solution {
	@Test
	public void execute() {
		System.out.println(findShortestPath(new GridMaster()));
	}
	private class GridMaster {
		private int[] cur = new int[]{1, 4};
		private int[][] grid = new int[][]{
				{1,1,1,1,1},
				{1,0,1,1,-1},
				{2,1,1,1,1}
		};

		public boolean canMove(char direction) {
			int nextY = 0, nextX = 0;
			switch (direction) {
				case 'U' : nextY = cur[0] - 1; nextX = cur[1];
					break;
				case 'D' : nextY = cur[0] + 1; nextX = cur[1];
					break;
				case 'L' : nextY = cur[0]; nextX = cur[1] - 1;
					break;
				case 'R' : nextY = cur[0]; nextX = cur[1] + 1;
					break;
			}
			return 0 <= nextY && nextY < grid.length && 0 <= nextX && nextX < grid[0].length && grid[nextY][nextX] != 0;
		}

		public void move(char direction) {
			switch (direction) {
				case 'U' : cur[0] -= 1;
					break;
				case 'D' : cur[0] += 1;
					break;
				case 'L' : cur[1] -= 1;
					break;
				case 'R' : cur[1] += 1;
					break;
			}
		}

		boolean isTarget() {
			return grid[cur[0]][cur[1]] == 2;
		}
	}

	private static final int[][] dirArr = new int[][]{
			{(int) 'U', -1, 0},
			{(int) 'L', 0, -1},
			{(int) 'D', 1, 0},
			{(int) 'R', 0, 1}
	};

	private int getQuadrant(int y, int x) {
		if (0 < y && 0 <= x) return 3;
		else if (0 < y && x < 0) return 2;
		else if (y <= 0 && x < 0) return 1;
		else return 0;
	}

	private static final int UNABLE = -1;
	private static final int FOUNDING = -2;

	private int recursion(int curY, int curX, int quadrant, Integer prevMinCost, Integer[][][] memoization, GridMaster gridMaster) {
		if (gridMaster.isTarget()) return 0;
		else if (memoization[quadrant][Math.abs(curY)][Math.abs(curX)] != null)
			return memoization[quadrant][Math.abs(curY)][Math.abs(curX)];

		memoization[quadrant][Math.abs(curY)][Math.abs(curX)] = FOUNDING;

		int minCost = prevMinCost != null ? prevMinCost : UNABLE;
		for (int i = 0; i < 4; i++) {
			int[] dir = dirArr[i];
			if (gridMaster.canMove((char) dir[0])) {
				int nextY = curY + dir[1];
				int nextX = curX + dir[2];
				int nextQuadrant = getQuadrant(nextY, nextX);

				if (memoization[nextQuadrant][Math.abs(nextY)][Math.abs(nextX)] == null || memoization[nextQuadrant][Math.abs(nextY)][Math.abs(nextX)] != FOUNDING) {
					gridMaster.move((char) dir[0]);
					int cost = recursion(nextY, nextX, nextQuadrant, minCost != UNABLE ? minCost + 1 : null, memoization, gridMaster);
					if (cost != UNABLE) minCost = minCost == UNABLE ? cost + 1 : Math.min(minCost, cost + 1);
					gridMaster.move((char) dirArr[(i + 2) % 4][0]);
				}
			}
		}
		memoization[quadrant][Math.abs(curY)][Math.abs(curX)] = minCost;
		return minCost;
	}

	public int findShortestPath(GridMaster master) {
		Integer[][][] memoization = new Integer[4][500][500];
		return recursion(0, 0, 0, null, memoization, master);
	}
}
