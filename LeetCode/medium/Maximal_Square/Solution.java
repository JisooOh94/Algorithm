package medium.Maximal_Square;

import org.junit.Test;

/**
 * Runtime : 3ms(99.23%)
 * Memory : 41.9mb(99.26%)
 */
public class Solution {
	@Test
	public void execute() {
		char[][] matrix = new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		System.out.println(maximalSquare(matrix));
	}
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int[][] vertSum = new int[matrix.length][matrix[0].length];
		int[][] horzSum = new int[matrix.length][matrix[0].length];
		int[][] squareSum = new int[matrix.length][matrix[0].length];


		for(int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[0].length; x++) {
				if(matrix[y][x] == '1') horzSum[y][x] = x == 0 ? 1 : horzSum[y][x - 1] + 1;
			}
		}

		for(int x = 0; x < matrix[0].length; x++) {
			for (int y = 0; y < matrix.length; y++) {
				if(matrix[y][x] == '1') vertSum[y][x] = y == 0 ? 1 : vertSum[y - 1][x] + 1;
			}
		}

		int maxSquareSize = 0;
		for(int y = 0; y < matrix.length; y++) {
			for(int x = 0; x < matrix[0].length; x++) {
				if(matrix[y][x] == '1'){
					int len = x == 0 || y == 0 ? 1 : Math.min(Math.min(vertSum[y][x],horzSum[y][x]), squareSum[y - 1][x - 1] + 1);

					squareSum[y][x] = len;

					maxSquareSize = Math.max(maxSquareSize, len * len);
				}
			}
		}

		return maxSquareSize;
	}
}
