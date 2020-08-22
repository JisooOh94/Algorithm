package medium.Greatest_Sum_Divisible_by_Three;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,2,3,4,4};

		System.out.println(maxSumDivThree(nums));
	}

	private int recursion(int idx, int sum, int[] nums, Integer[][] record) {
		if(idx == nums.length) return sum % 3 == 0 ? sum : 0;
		else if(record[idx][sum] != null) return record[idx][sum];

		int maxSum = sum % 3 == 0 ? sum : 0;
		for(int i = idx; i < nums.length; i++) {
			maxSum = Math.max(maxSum, recursion(i + 1, sum + nums[i], nums, record));
		}

		record[idx][sum] = maxSum;

		return maxSum;
	}

	public int maxSumDivThree(int[] nums) {
		Integer[][] record = new Integer[nums.length][10000000];
		return recursion(0, 0, nums, record);
	}
}
