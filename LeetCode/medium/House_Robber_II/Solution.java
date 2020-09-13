package medium.House_Robber_II;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.9mb(64.53%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{2,3,2};
		int[] nums = new int[]{1,2,3,1};
		System.out.println(rob(nums));
	}
	private static final int SELECTED = 0;
	private static final int NOT_SELECTED = 1;
	private int recursion(int curIdx, int prevSelected, int firstSelected, int[] nums, Integer[][][] record) {
		if(curIdx == nums.length) return 0;
		else if(record[curIdx][prevSelected][firstSelected] != null) return record[curIdx][prevSelected][firstSelected];

		int maxSum = recursion(curIdx + 1, NOT_SELECTED, firstSelected, nums, record);
		if(prevSelected == NOT_SELECTED && (curIdx < nums.length -1 || firstSelected == NOT_SELECTED)) maxSum = Math.max(maxSum, nums[curIdx] + recursion(curIdx + 1, SELECTED, firstSelected, nums, record));

		record[curIdx][prevSelected][firstSelected] = maxSum;
		return maxSum;
	}
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		else if(nums.length == 1) return nums[0];
		Integer[][][] record = new Integer[nums.length][2][2];
		return Math.max(nums[0] + recursion(1, SELECTED, SELECTED, nums, record), recursion(1, NOT_SELECTED, NOT_SELECTED, nums, record));
	}
}
