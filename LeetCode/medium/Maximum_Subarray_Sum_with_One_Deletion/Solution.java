package medium.Maximum_Subarray_Sum_with_One_Deletion;

import org.junit.Test;

/**
 * Runtime : 25ms(5.42%)
 * Memory : 76.7mb(5.15%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] arr = new int[]{1,-2,-2,3};
//		int[] arr = new int[]{1,-2,0,3};
		int[] arr = new int[]{-1,-1,-1,-1};
		System.out.println(maximumSum(arr));
	}

	private static final int Y = 1;
	private static final int N = 0;
	private int recursion(int idx, int isJumped, int[] arr, Integer[][] record) {
		if(idx >= arr.length) return 0;
		else if(record[idx][isJumped] != null) return record[idx][isJumped];

		int max = arr[idx];
		max = Math.max(max, arr[idx] + recursion(idx + 1, isJumped, arr, record));
		if(isJumped == N) max = Math.max(max, arr[idx] + recursion(idx + 2, Y, arr, record));

		record[idx][isJumped] = max;
		return max;
	}

	public int maximumSum(int[] arr) {
		Integer max = null;
		Integer[][] record = new Integer[arr.length][2];
		for(int i = 0; i < arr.length; i++) {
			int result = recursion(i, N, arr, record);
			max = max == null ? result : Math.max(max, result);
		}
		return max;
	}
}
