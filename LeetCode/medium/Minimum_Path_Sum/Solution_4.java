package medium.Minimum_Path_Sum;

import org.junit.Test;

/**
 * Runtime : 3ms(44.42%)
 * Memory : 42.1mb(44.18%)
 * Time Complexity : O(n)
 * Subject : DP
 */
public class Solution_4 {
	@Test
	public void execute() {
		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
//		int[][] grid = new int[][]{{1,2,3},{4,5,6}};
		System.out.println(minPathSum(grid));
	}
	public int minPathSum(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		Integer[][] minVal = new Integer[height][width];
		minVal[0][0] = grid[0][0];
		for(int y = 1; y < height; y++) minVal[y][0] = minVal[y - 1][0] + grid[y][0];
		for(int x = 1; x < width; x++) minVal[0][x] = minVal[0][x - 1] + grid[0][x];

		for(int y = 1; y < height; y++)
			for(int x = 1; x < width; x++)
				minVal[y][x] = Math.min(minVal[y - 1][x], minVal[y][x - 1]) + grid[y][x];

		return minVal[height - 1][width - 1];
	}
}
