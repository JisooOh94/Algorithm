package medium.Find_Valid_Matrix_Given_Row_and_Column_Sums;

/**
 * Runtime : 6ms(76.55%)
 * Memory : 47.7mb(27.15%)
 * Time Complexity : O(n)
 * Subject : Greedy
 */
public class Solution {
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int[][] estimatedMap = new int[rowSum.length][colSum.length];
		for(int y = 0; y < rowSum.length - 1; y++) {
			for(int x = 0; x < colSum.length - 1; x++) {
				int estimatedVal = Math.min(rowSum[y], colSum[x]);
				estimatedMap[y][x] = estimatedVal;
				rowSum[y] -= estimatedVal;
				colSum[x] -= estimatedVal;
			}
			estimatedMap[y][colSum.length - 1] = rowSum[y];
			colSum[colSum.length - 1] -= rowSum[y];
		}

		for(int x = 0; x < colSum.length; x++) {
			estimatedMap[rowSum.length - 1][x] = colSum[x];
		}

		return estimatedMap;
	}
}
