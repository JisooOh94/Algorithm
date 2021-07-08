package medium.MinimuDifference_Between_Largest_and_Smallest_Value_in_Three_Moves;

import java.util.Arrays;

/**
 * Runtime : 19ms(32.53%)
 * Memory : 54.4mb(63.94%)
 * Time Complexity : O(nlogn)
 */
public class Solution {
	public int minDifference(int[] nums) {
		if(nums.length < 5) return 0;

		Arrays.sort(nums);
		return Math.min(
				Math.min(Math.abs(nums[0] - nums[nums.length - 1 - 3]), Math.abs(nums[3] - nums[nums.length - 1])),
				Math.min(Math.abs(nums[2] - nums[nums.length - 1 - 1]), Math.abs(nums[1] - nums[nums.length -1 - 2]))
		);
	}
}
