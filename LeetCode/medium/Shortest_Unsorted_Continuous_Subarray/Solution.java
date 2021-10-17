package medium.Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

/**
 * Time : 1ms(100.00%)
 * Memory : 40.5mb(50.92%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int findUnsortedSubarray(int[] nums) {
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);

		int from = -1, to = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != copy[i]) {
				from = i;
				break;
			}
		}

		if(from == -1) return 0;

		for(int i = nums.length - 1; from < i; i--) {
			if(nums[i] != copy[i]) {
				to = i;
				break;
			}
		}

		return to - from + 1;
	}
}
