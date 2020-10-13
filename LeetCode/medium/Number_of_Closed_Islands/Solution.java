package medium.Number_of_Closed_Islands;

import org.junit.Test;

/**
 * Runtime : 2ms(74.66%)
 * Memory : 39.6mb(8.26%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] grid = new int[][]{
				{0,0,1,1,0,1,0,0,1,0},
				{1,1,0,1,1,0,1,1,1,0},
				{1,0,1,1,1,0,0,1,1,0},
				{0,1,1,0,0,0,0,1,0,1},
				{0,0,0,0,0,0,1,1,1,0},
				{0,1,0,1,0,1,0,1,1,1},
				{1,0,1,0,1,1,0,0,0,1},
				{1,1,1,1,1,1,0,0,0,0},
				{1,1,1,0,0,1,0,1,0,1},
				{1,1,1,0,1,1,0,1,1,0}
		};

		System.out.println(closedIsland(grid));
	}
	int[][] direction = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	private boolean markLand(int curY, int curX, int[][] grid) {
		if(-1 == curX || curX == grid[0].length || -1 == curY || curY == grid.length) return false;
		else if(grid[curY][curX] == 1) return true;

		grid[curY][curX] = 1;

		boolean result = true;
		for(int i = 0; i < 4; i++) {
			result =  markLand(curY + direction[i][0], curX + direction[i][1], grid) && result;
		}
		return result;
	}
	public int closedIsland(int[][] grid) {
		int landCnt = 0;
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == 0) {
					if(markLand(y, x, grid)) landCnt++;
				}
			}
		}
		return landCnt;
	}
}
