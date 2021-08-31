package medium.Maximum_Matrix_Sum;

import org.junit.Test;

/**
 * Runtime : 4ms(99.05%)
 * Memory : 48.3mb(74.93%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] mat = new int[][]{{1,-1},{-1,1}};
		int[][] mat = new int[][]{{1,2,3},{-1,-2,-3},{1,2,3}};
		System.out.println(maxMatrixSum(mat));
	}

	public long maxMatrixSum(int[][] mat) {
		long sum = 0;
		int min = 100001;
		int minusCnt = 0;
		for(int[] row : mat) {
			for(int elem : row) {
				int absVal = Math.abs(elem);
				min = Math.min(min, absVal);
				if(elem < 0) minusCnt++;
				sum += absVal;
			}
		}
		if(minusCnt % 2 != 0) sum -= min * 2;
		return sum;
	}
}
