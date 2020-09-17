package medium.Unique_Paths_II;

import org.junit.Test;

/**
 * Runtime : 0 ms(100.00%)
 * Memory : 39.9 mb(5.03%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] grid = new int[][]{
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		System.out.println(uniquePathsWithObstacles(grid));
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
		int height = obstacleGrid.length;
		int width = obstacleGrid[0].length;

		if(obstacleGrid[0][0] == 1 || obstacleGrid[height - 1][width - 1] == 1) return 0;
		int[][] record = new int[height][width];

		record[0][0] = 1;
		for(int y = 0; y < height; y++) {
			for(int x = (y == 0 ? 1 : 0); x  < width; x++) {
				if(obstacleGrid[y][x] == 1) continue;
				record[y][x] = (y == 0 ? 0 : record[y - 1][x]) + (x == 0 ? 0 : record[y][x - 1]);
			}
		}

		return record[height - 1][width - 1];
	}
}
