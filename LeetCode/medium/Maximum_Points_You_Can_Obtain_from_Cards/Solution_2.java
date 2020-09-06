package medium.Maximum_Points_You_Can_Obtain_from_Cards;

import org.junit.Test;
import util.PerformanceUtil;

/**
 * Runtime : 1ms(100.00%)
 * Memory : 48.8mb(59.42%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{1,2,3,4,5,6,1}; int left = 3;
//		int[] nums = new int[]{1,79,80,1,1,1,200,1}; int left = 3;
		PerformanceUtil.beforeTest();
		System.out.println(maxScore(nums, left));
		System.out.println(PerformanceUtil.afterTest());
	}

	public int maxScore(int[] nums, int left) {
		int curSum = 0;
		int excludeLen = nums.length - left;
		for(int i = 0; i < excludeLen; i++) {
			curSum += nums[i];
		}

		int totalSum = curSum;
		for(int i = excludeLen; i < nums.length; i++) {
			totalSum += nums[i];
		}

		int maxSum = totalSum - curSum;
		for(int i = 0; i < left; i++) {
			curSum -= nums[i];
			curSum += nums[excludeLen + i];

			maxSum = Math.max(maxSum, totalSum - curSum);
		}

		return maxSum;
	}
}
