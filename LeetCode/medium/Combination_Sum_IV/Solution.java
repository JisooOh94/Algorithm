package medium.Combination_Sum_IV;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.8mb(51.23%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1, 2, 3};
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}
	private int recursion(int target, int[] nums, Integer[] record) {
		if(target == 0) return 1;
		else if(record[target] != null) return record[target];
		int waySum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(target < nums[i]) break;
			waySum += recursion(target - nums[i], nums, record);
		}
		record[target] = waySum;
		return waySum;
	}
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		Integer[] record = new Integer[target + 1];
		return recursion(target, nums, record);
	}
}
