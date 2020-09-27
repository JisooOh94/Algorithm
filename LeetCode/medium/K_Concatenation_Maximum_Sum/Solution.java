package medium.K_Concatenation_Maximum_Sum;

import org.junit.Test;

/**
 * Runtime : 3ms(92.84%)
 * Memory : 56.1mb(21.49%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//		int[] arr = new int[]{-1,-2}; int k = 7;
		int[] arr = new int[]{1,0,4,1,4}; int k = 4;
		System.out.println(kConcatenationMaxSum(arr, k));
	}
	private static final int MOD = (int)Math.pow(10, 9) + 7;
	public long[] maxSubArray(int[] nums) {
		long curSum = nums[0];
		long maxSum = curSum;
		int curStartIdx = 0, curEndIdx = 0, maxStartidx = 0, maxEndIdx = 0;

		for(int i = 1; i < nums.length; i++) {
			if(curSum + nums[i] < nums[i]) {
				curStartIdx = i;
				curEndIdx = i;
				curSum = nums[i];
			} else {
				curEndIdx = i;
				curSum += nums[i];
			}

			if(maxSum < curSum) {
				maxSum = curSum;
				maxStartidx = curStartIdx;
				maxEndIdx = curEndIdx;
			}
		}

		return new long[]{maxSum, maxStartidx, maxEndIdx};
	}

	public int kConcatenationMaxSum(int[] arr, int k) {
		int[] arrCpy;
		if(k == 1) {
			arrCpy = arr;
		}
		else if(k == 2) {
			arrCpy = new int[arr.length * 2];
			System.arraycopy(arr, 0, arrCpy, 0, arr.length);
			System.arraycopy(arr, 0, arrCpy, arr.length, arr.length);
		} else {
			arrCpy = new int[arr.length * 3];
			System.arraycopy(arr, 0, arrCpy, 0, arr.length);
			System.arraycopy(arr, 0, arrCpy, arr.length, arr.length);
			System.arraycopy(arr, 0, arrCpy, arr.length * 2, arr.length);
		}

		long[] result = maxSubArray(arrCpy);

		if(result[2] < arr.length || (arr.length <= result[2] && result[2] < arr.length * 2)) return result[0] < 0 ? 0 : (int)(result[0] % MOD);
		else {
			long totalSum = 0;
			for(int num : arr) totalSum += num;
			long resultSum = result[0] + ((k - 3) * totalSum);
			return resultSum < 0 ? 0 : (int)(resultSum % MOD);
		}
	}
}
