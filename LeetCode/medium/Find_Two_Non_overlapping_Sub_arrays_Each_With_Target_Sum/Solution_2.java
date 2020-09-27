package medium.Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import org.junit.Test;

/**
 * Runtime : 11ms(69.49%)
 * Memory : 88.1mb(22.50%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[] nums = new int[]{3,2,2,4,3}; int target = 3;
		int[] nums = new int[]{2,2,4,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int[] nums_1 = new int[]{4,4,4,4,4};
		int[] nums_2 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(nums_1.length);
		System.out.println(nums_2.length);
		int target = 20;

		System.out.println(minSumOfLengths(nums, target));
	}
	private static final int MAX_LEN = 1000000;
	public int minSumOfLengths(int[] nums, int target) {
		int[] minInfo = new int[]{MAX_LEN, 0, 0};
		int curSum = 0;
		for(int frIdx = 0, reIdx = 0; reIdx <= nums.length; ) {
			if(target <= curSum) {
				if(target == curSum && reIdx - frIdx < minInfo[0]) {
					minInfo[0] = reIdx - frIdx;
					minInfo[1] = frIdx;
					minInfo[2] = reIdx;
				}
				curSum -= nums[frIdx++];
			} else {
				curSum += reIdx == nums.length ? 0 : nums[reIdx];
				reIdx++;
			}
		}

		if(minInfo[0] >= MAX_LEN) return -1;

		int nextMinSum = MAX_LEN;
		curSum = 0;
		for(int frIdx = 0, reIdx = 0; reIdx <= minInfo[1];) {
			if(target <= curSum) {
				nextMinSum = target == curSum ? Math.min(nextMinSum, reIdx - frIdx) : nextMinSum;
				curSum -= nums[frIdx++];
			} else {
				curSum += reIdx == minInfo[1] ? 0 : nums[reIdx];
				reIdx++;
			}
		}

		curSum = 0;
		for(int frIdx = minInfo[2], reIdx = frIdx; reIdx <= nums.length; ) {
			if(target <= curSum) {
				nextMinSum = target == curSum ? Math.min(nextMinSum, reIdx - frIdx) : nextMinSum;
				curSum -= nums[frIdx++];
			} else {
				curSum += reIdx == nums.length ? 0 : nums[reIdx];
				reIdx++;
			}
		}

		if(nextMinSum >= MAX_LEN) return -1;
		return minInfo[0] + nextMinSum;
	}
}
