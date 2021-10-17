package medium.Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

/**
 * Time : 6ms(44.09%)
 * Memory : 40.4mb(64.96%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Answer {
	public int findUnsortedSubarray(int[] nums) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int from = -1, to = -1;

		for(int i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max);
			min = Math.min(nums[nums.length - i - 1], min);
			if(nums[i] < max) to = i;
			if(nums[nums.length - i - 1] > min) from = nums.length - i - 1;
		}
		return from == -1 ? 0 : to - from + 1;
	}
}
