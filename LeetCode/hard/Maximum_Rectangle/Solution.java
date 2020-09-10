package hard.Maximum_Rectangle;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 33ms(5.33%)
 * Memory : 42.6mb(73.98%)
 */
public class Solution {
	@Test
	public void execute() {
		char[][] mat = new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		System.out.println(maximalRectangle(mat));
	}

	public int maximalRectangle(char[][] mat) {
		if(mat == null || mat.length == 0 || mat[0].length == 0) return 0;
		int y_size = mat.length, x_size = mat[0].length;

		int maxSize = 0;
		for (int up = 0; up < y_size; ++up) {
			int[] histo = new int[x_size];
			Arrays.fill(histo, 1);
			for (int down = up; down < y_size; ++down) {
				for (int x = 0; x < x_size; ++x) histo[x] = mat[down][x] == '0' ? 0 : histo[x];
				int curSize = countOneRow(histo) * (down - up + 1);
				maxSize = Math.max(maxSize, curSize);
			}
		}
		return maxSize;
	}

	private int countOneRow(int[] histo) {
		int res = 0, length = 0;
		for (int i = 0; i < histo.length; ++i) {
			length = (histo[i] == 0 ? 0 : length + 1);
			res = Math.max(length, res);
		}
		return res;
	}
}
