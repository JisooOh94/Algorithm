package LeetCode.Minimum_Path_Sum;

import java.util.Arrays;

import util.Predicate;

/**
 * Runtime : 158ms(5.67%)
 * Memory : 42mb(87.84)
 */
public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return minPathSum((int[][]) params[0]);
	}

	private static int min = 999999;

	private void recursion(int[][] grid, int[][] minGrid, int xPos, int yPos, int curSum) {
		if(curSum >= min) return;

		if(xPos == grid[0].length - 1 && yPos == grid.length - 1) {
			min = curSum;
			return;
		}

		if(minGrid[yPos][xPos] == -1 || curSum < minGrid[yPos][xPos]) {
			minGrid[yPos][xPos] = curSum;
		} else {
			return;
		}

		if(xPos < grid[0].length - 1) recursion(grid, minGrid, xPos + 1, yPos, curSum + grid[yPos][xPos + 1]);

		if(yPos < grid.length - 1) recursion(grid, minGrid, xPos, yPos + 1, curSum + grid[yPos + 1][xPos]);
	}

	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

		int[][] minGrid = new int[grid.length][grid[0].length];
		for(int[] arr : minGrid) {
			Arrays.fill(arr, -1);
		}

		recursion(grid, minGrid, 0, 0, grid[0][0]);
		return min;
	}
}
