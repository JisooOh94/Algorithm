package medium.Minimize_Maximum_Pair_Sum_in_Array;

import java.util.Arrays;

/**
 * Runtime : 51ms(73.89%)
 * Memory : 55.3mb(57.94%)
 * Time Complexity : O(n)
 * Subject: greedy
 */
public class Solution {
	public int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int max = 0;
		for(int i = 0; i < nums.length / 2; i++) {
			max = Math.max(max, nums[i] + nums[nums.length - i - 1]);
		}
		return max;
	}
}
