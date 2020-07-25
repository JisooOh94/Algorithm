package medium.Minimum_Falling_Path_Sum;

import org.junit.Test;

/**
 * Runtime : 1ms(100.00%)
 * Memory : 40.2mb(24.47%)
 */
public class Solution {
	@Test
	public void exectue() {
//		int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] A = new int[][]{{17, 82},{1, -44}};
		System.out.println(minFallingPathSum(A));
	}
	private int recursion(int[][] arr, int[][] record, int row, int col) {
		if(row == arr.length - 1) return arr[row][col];
		else if(record[row][col] != 0) return record[row][col];

		int minSum = 9999999;
		for(int i = Math.max(0, col -1); i < Math.min(arr[0].length, col + 2); i++) {
			int curSum = recursion(arr, record, row + 1, i);
			if(curSum < minSum) minSum = curSum;
		}
		minSum += arr[row][col];
		record[row][col] = minSum;
		return minSum;
	}

	public int minFallingPathSum(int[][] A) {
		int minSum = 9999;
		int[][] record = new int[A.length][A[0].length];

		for(int i = 0; i < A.length; i++) {
			int curSum = recursion(A, record, 0, i);
			if(curSum < minSum) minSum = curSum;
		}
		return minSum;
	}
}
