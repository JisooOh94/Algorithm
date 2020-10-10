package medium.Max_Area_of_Island;

/**
 * Runtime : 2ms(99.56%)
 * Memory : 39.5mb(16.64%)
 */
public class Solution {
	private int recursion(int y, int x, int[][] grid) {
		grid[y][x] = 0;

		int size = 1;
		if(0 <= y - 1 && grid[y - 1][x] == 1) size += recursion(y - 1, x, grid);
		if(y + 1 < grid.length && grid[y + 1][x] == 1) size += recursion(y + 1, x, grid);
		if(0 <= x - 1 && grid[y][x - 1] == 1) size += recursion(y, x - 1, grid);
		if(x + 1 < grid[0].length && grid[y][x + 1] == 1) size += recursion(y, x + 1, grid);

		return size;
	}

	public int maxAreaOfIsland(int[][] grid) {
		int maxSize = 0;
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == 1) {
					maxSize = Math.max(maxSize, recursion(y, x, grid));
				}
			}
		}
		return maxSize;
	}
}
