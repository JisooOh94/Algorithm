package medium.Largest_1_Bordered_Square;

import org.junit.Test;

/**
 * Runtime : 9ms(30.51%)
 * Memory : 40.6mb(47.18%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] grid = new int[][]{ {1,1,1},{1,0,1},{1,1,1} };
//		int[][] grid = new int[][]{{1,1,0,0}};
//		int[][] grid = new int[][]{
//				{0,1,1,1,1,0},
//				{1,1,0,1,1,0},
//				{1,1,0,1,0,1},
//				{1,1,0,1,1,1},
//				{1,1,0,1,1,1},
//				{1,1,1,1,1,1},
//				{1,0,1,1,1,1},
//				{0,0,1,1,1,1},
//				{1,1,1,1,1,1}
//		};
//		int[][] grid = new int[][]{{0,0}, {0, 1}};
//		int[][] grid = new int[][]{
//				{1,1,1},
//				{0,1,0},
//				{0,1,1},
//				{1,1,1},
//				{1,1,1},
//				{1,1,1}};
		int[][] grid = new int[][]{
				{1,1,1,1,1,1,1,1},
				{0,1,0,1,1,1,1,0},
				{1,1,0,1,0,1,1,1},
				{1,1,1,1,1,1,0,0}
		};
		System.out.println(largest1BorderedSquare(grid));
	}
	public int largest1BorderedSquare(int[][] grid) {
		int maxSize = 0;
		int[][][] memo = new int[grid.length][grid[0].length][2];
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == 1) {
					maxSize = 1;
					memo[y][x][0] = y == 0 ? 1 : memo[y - 1][x][0] + 1;
					memo[y][x][1] = x == 0 ? 1 : memo[y][x - 1][1] + 1;
				} else {
					memo[y][x][0] = memo[y][x][1] = 0;
				}
			}
		}

		for(int y = 0; y < memo.length; y++) {
			for(int x = 0; x < memo[0].length; x++) {
				int len = Math.min(memo[y][x][0], memo[y][x][1]);
				for(int k = len; maxSize < k || 1 < k; k--) {
					int yIdx = y - k + 1;
					int xIdx = x - k + 1;
					if(memo[yIdx][x][1] >= k && memo[y][xIdx][0] >= k) {
						maxSize = Math.max(maxSize, k);
					}
				}

			}
		}
		return (int)Math.pow(maxSize, 2);
	}
}
