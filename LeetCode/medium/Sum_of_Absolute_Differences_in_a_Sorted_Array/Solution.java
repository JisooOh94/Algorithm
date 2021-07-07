package medium.Sum_of_Absolute_Differences_in_a_Sorted_Array;

import java.util.Arrays;

/**
 * Runtime : 18ms(5.22%)
 * Memory : 133.3mb(5.22%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		int totalSum = Arrays.stream(nums).sum();
		int[] result = new int[nums.length];
		int leftSum = 0;
		int rightSum = totalSum;
		for(int i = 0; i < nums.length; i++) {
			rightSum -= nums[i];
			int leftResult = nums[i] * i - leftSum;
			int rightResult = rightSum - nums[i] * (nums.length - i - 1);
			result[i] = leftResult + rightResult;
			leftSum += nums[i];
		}
		return result;
	}
}
