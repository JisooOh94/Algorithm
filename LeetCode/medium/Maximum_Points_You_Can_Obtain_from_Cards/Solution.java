package medium.Maximum_Points_You_Can_Obtain_from_Cards;

import org.junit.Test;
import util.PerformanceUtil;

public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{1,2,3,4,5,6,1}; int left = 3;
		int[] nums = new int[]{1,79,80,1,1,1,200,1}; int left = 3;
		PerformanceUtil.beforeTest();
		System.out.println(maxScore(nums, left));
		System.out.println(PerformanceUtil.afterTest());
	}

	private int recursion(int front, int rear, int left, int orgLeft, int[] nums, Integer[][] record) {
		if (left == 0) return 0;
		else if (record[front][rear - orgLeft] != null) {
			return record[front][rear - orgLeft];
		}

		int max = Math.max(recursion(front + 1, rear, left - 1, orgLeft, nums, record) + nums[front], recursion(front, rear - 1, left - 1, orgLeft, nums, record) + nums[rear]);
		record[front][rear - orgLeft] = max;
		return max;
	}

	public int maxScore(int[] nums, int left) {
		if(nums.length == 0) return nums[0];
		else if(nums.length == left) {
			int result = 0;
			for(int num : nums) result += num;
			return result;
		}

		Integer[][] record = new Integer[left][left];
		return recursion(0, nums.length - 1, left, nums.length - left, nums, record);
	}
}
