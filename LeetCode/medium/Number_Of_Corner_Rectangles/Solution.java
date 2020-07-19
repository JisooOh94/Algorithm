package medium.Number_Of_Corner_Rectangles;

import org.junit.Test;

/**
 * Runtime : 153ms(27.70%)
 * Memory : 114.2mb(6.06%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] grid = new int[][]{{1,1,1,0,1}, {1,1,1,1,1}};
//		int[][] grid = new int[][]{{1,1,1,1,1}, {1,1,1,1,1}};
//		int[][] grid = new int[][]{
//				{1, 0, 0, 1, 0},
//				{0, 0, 1, 0, 1},
//				{0, 0, 0, 1, 0},
//				{1, 0, 1, 0, 1}
//		};
		int[][] grid = new int[][]{
				{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}
		};
		System.out.println(countCornerRectangles(grid));
	}

	public int countCornerRectangles(int[][] grid) {
		int width = grid[0].length;
		int height = grid.length;
		int squareCnt = 0;

		for (int y = 1; y < height; y++) {
			for (int idx = 1; idx <= y; idx++) {
				boolean startFound = false;
				int[] record = new int[width + 1];
				for (int x = width - 1; 0 <= x; x--) {
					if (grid[y][x] == 1 && grid[y - idx][x] == 1) {
						if (record[x + 1] != 0) {
							record[x] = record[x + 1] + 1;
							squareCnt += record[x];
						} else {
							if (startFound) {
								record[x] = 1;
								squareCnt += record[x];
							} else startFound = true;
						}
					} else {
						record[x] = record[x + 1];
					}
				}
			}
		}
		return squareCnt;
	}
}
