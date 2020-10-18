package medium.Lonely_Pixel_I;

import org.junit.Test;

/**
 * Runtime : 2ms(77.82%)
 * Memory : 44.3mb(16.74%)
 */
public class Solution {
	@Test
	public void execute() {
		char[][] picture = new char[][]{
				{'W','W','B'},{'W','B','B'},{'B','W','W'}
		};

		System.out.println(findLonelyPixel(picture));
	}
	private static char BLACK = 'B';

	public int findLonelyPixel(char[][] picture) {
		int[] row = new int[picture.length];
		int[] col = new int[picture[0].length];

		for (int y = 0; y < picture.length; y++) {
			for (int x = 0; x < picture[0].length; x++) {
				if (picture[y][x] == BLACK) {
					row[y] = row[y] == 0 ? 1 : -1;
					col[x] = col[x] == 0 ? 1 : -1;
				}
			}
		}

		int lonelyCnt = 0;
		for (int y = 0; y < picture.length; y++) {
			if (row[y] == 1) {
				for (int x = 0; x < picture[0].length; x++) {
					if (picture[y][x] == BLACK && col[x] == 1) {
						lonelyCnt++;
						break;
					}
				}
			}
		}
		return lonelyCnt;
	}
}
