package medium.Range_Sum_Query_2D_Immutable;

import org.junit.Test;

/**
 * Runtime : 11ms(88.47%)
 * Memory : 45.4mb(59.20%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] matrix = new int[][]{
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		};
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(1, 2, 1, 2));
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
	}
}
