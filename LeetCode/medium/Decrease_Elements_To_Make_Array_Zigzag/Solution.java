package medium.Decrease_Elements_To_Make_Array_Zigzag;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.5mb(64.02%
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,2,3};
		System.out.println(movesToMakeZigzag(nums));
	}
	public int movesToMakeZigzag(int[] nums) {
		if(nums.length == 1) return 0;
		int oddIdx = 0;
		int evenIdx = 1;

		int oddSum = 0;
		int evenSum = 0;

		while(oddIdx < nums.length || evenIdx < nums.length) {
			if(oddIdx < nums.length) {
				int oddMin = oddIdx == 0 ? nums[oddIdx + 1] : oddIdx == nums.length - 1 ? nums[oddIdx - 1] : Math.min(nums[oddIdx - 1], nums[oddIdx + 1]);
				if (oddMin <= nums[oddIdx]) oddSum += nums[oddIdx] - (oddMin - 1);
			}
			if(evenIdx < nums.length) {
				int evenMin = evenIdx == nums.length - 1 ? nums[evenIdx - 1] : Math.min(nums[evenIdx - 1], nums[evenIdx + 1]);
				if (evenMin <= nums[evenIdx]) evenSum += nums[evenIdx] - (evenMin - 1);
			}

			oddIdx += 2;
			evenIdx += 2;
		}

		return Math.min(oddSum, evenSum);
	}
}
