package medium.Count_Servers_that_Communicate;

import org.junit.Test;

/**
 * Runtime : 2ms(97.82%)
 * Memory : 45.3mb(99.22%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] grid = new int[][]{
				{1, 1, 0, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 1}
		};
		System.out.println(countServers(grid));
	}
	public int countServers(int[][] grid) {
		boolean[] rowExist= new boolean[grid.length];
		boolean[] colExist = new boolean[grid[0].length];
		Integer[] rowNotCounted = new Integer[grid.length];
		Integer[] colNotCounted = new Integer[grid[0].length];

		int connected = 0;
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == 1) {
					if(rowExist[y] || colExist[x]) {
						connected++;

						if(rowNotCounted[y] != null) {
							connected++;
							colNotCounted[rowNotCounted[y]] = null;
							rowNotCounted[y] = null;
						}
						if(colNotCounted[x] != null) {
							connected++;
							rowNotCounted[colNotCounted[x]] = null;
							colNotCounted[x] = null;
						}
					} else {
						rowNotCounted[y] = x;
						colNotCounted[x] = y;
					}
					rowExist[y] = colExist[x] = true;
				}
			}
		}

		return connected;
	}
}
