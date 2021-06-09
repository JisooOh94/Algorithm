package medium.Maximum_Absolute_Sum_of_Any_Subarray;

import org.junit.Test;

/**
 * Runtime : 4ms(51.18%)
 * Memory : 47.5mb(72.41%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{2,-5,1,-4,3,-2};

		System.out.println(maxAbsoluteSum(nums));
	}

	public int maxAbsoluteSum(int[] nums) {
		int curSum = 0, prevSum = 0, oppositeSum = 0, curIdx = 0, maxPlusSum = 0, maxMinusSum = 0;

		while(curIdx < nums.length) {
			if(0 <= nums[curIdx]) {
				curSum += nums[curIdx++];
			} else {
				prevSum = oppositeSum < prevSum ? prevSum + curSum - oppositeSum : curSum;
				maxPlusSum = Math.max(maxPlusSum, prevSum);
				curSum = oppositeSum = 0;
				while(curIdx < nums.length && nums[curIdx] < 0) oppositeSum += nums[curIdx++] * -1;
			}
		}

		if(curSum != 0) {
			prevSum = oppositeSum < prevSum ? prevSum + curSum - oppositeSum : curSum;
			maxPlusSum = Math.max(maxPlusSum, prevSum);
		}

		curSum = prevSum = oppositeSum = curIdx = 0;

		while(curIdx < nums.length) {
			if(nums[curIdx] < 0) {
				curSum += nums[curIdx++] * -1;
			} else {
				prevSum = oppositeSum < prevSum ? prevSum + curSum - oppositeSum : curSum;
				maxMinusSum = Math.max(maxMinusSum, prevSum);
				curSum = oppositeSum = 0;
				while(curIdx < nums.length && 0 <= nums[curIdx]) oppositeSum += nums[curIdx++];
			}
		}

		if(curSum != 0) {
			prevSum = oppositeSum < prevSum ? prevSum + curSum - oppositeSum : curSum;
			maxMinusSum = Math.max(maxMinusSum, prevSum);
		}

		return Math.max(maxPlusSum, maxMinusSum);
	}
}
