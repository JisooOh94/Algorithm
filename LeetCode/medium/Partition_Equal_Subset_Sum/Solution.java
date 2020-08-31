package medium.Partition_Equal_Subset_Sum;

import org.junit.Test;

/**
 * Runtime : 29ms(58.12%)
 * Memory : 42.2mb(32.98%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{1, 5, 11, 5};
		int[] nums = new int[]{1, 2, 3, 10};

		System.out.println(canPartition(nums));
	}
	private boolean recursion(int curIdx, int curSum, int targetSum, int[] nums, Boolean[][] record) {
		if(targetSum == curSum) return true;
		else if(targetSum < curSum || curIdx == nums.length) return false;
		else if(record[curIdx][curSum] != null) return record[curIdx][curSum];

		if(recursion(curIdx + 1, curSum, targetSum, nums, record) || recursion(curIdx + 1, curSum + nums[curIdx], targetSum, nums, record)) return true;

		record[curIdx][curSum] = false;
		return false;
	}
	public boolean canPartition(int[] nums) {
		int targetSum = 0;
		for(int num : nums) targetSum += num;

		if(targetSum % 2 != 0) return false;

		targetSum /= 2;

		Boolean[][] record = new Boolean[nums.length][targetSum];
		return recursion(0, 0, targetSum, nums, record);
	}
}
