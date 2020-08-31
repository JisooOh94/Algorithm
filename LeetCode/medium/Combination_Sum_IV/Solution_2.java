package medium.Combination_Sum_IV;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 1ms(89.73%)
 * Memory : 36.8mb(79.43%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{1, 2, 3};
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}

	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] record = new int[target + 1];
		record[0] = 1;
		for(int localTarget = 1; localTarget <= target; localTarget++) {
			for(int j = 0; j < nums.length; j++) {
				if(localTarget < nums[j]) break;
				record[localTarget] += record[localTarget - nums[j]];
			}
		}

		return record[target];
	}
}
