package medium.Capacity_To_Ship_Packages_Within_D_Days;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] weights = new int[]{3,2,2,4,1,4};
		int D = 3;
		System.out.println(shipWithinDays(weights, D));
	}
	private int recursion(int idx, int[] nums, int day, int days, int curSum, int maxSum) {
		if(day == days && idx !=  nums.length) {
			for(int i = idx; i < nums.length; i++) curSum += nums[i];
			return Math.max(maxSum, curSum);
		}
		if(idx == nums.length) return maxSum;

		if(nums.length - idx == days - day) return recursion(idx + 1, nums, day + 1, days, nums[idx], Math.max(maxSum, nums[idx]));

		return Math.min(
				recursion(idx + 1, nums, day, days, curSum + nums[idx], Math.max(maxSum, curSum + nums[idx])),
				recursion(idx + 1, nums, day + 1, days, nums[idx], Math.max(maxSum, nums[idx]))
		);
	}

	public int shipWithinDays(int[] weights, int D) {
		return recursion(0, weights, 1, D, 0, 0);
	}
}
