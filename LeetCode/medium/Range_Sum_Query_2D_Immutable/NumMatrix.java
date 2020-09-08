package medium.Range_Sum_Query_2D_Immutable;

public class NumMatrix {
	private int[][] sum;

	public NumMatrix(int[][] matrix) {
		if(matrix != null && matrix.length != 0 && matrix[0].length != 0) {
			sum = new int[matrix.length + 1][matrix[0].length + 1];

			for (int y = 1; y <= matrix.length; y++) {
				for (int x = 1; x <= matrix[0].length; x++) {
					sum[y][x] = sum[y][x - 1] + sum[y - 1][x] - sum[y - 1][x - 1] + matrix[y - 1][x - 1];
				}
			}
		}
	}

	public int sumRegion(int y1, int x1, int y2, int x2) {
		return sum == null ? 0 : sum[y2 + 1][x2 + 1] - sum[y1][x2 + 1] - sum[y2 + 1][x1] + sum[y1][x1];
	}
}
