package medium.Longest_Increasing_Subsequence;

import org.junit.Test;

/**
 * Runtime : 32ms(10.86%)
 * Memory : 39.6mb(15.50%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[] nums = new int[]{10,9,2,5,3,7,101,18};
//		int[] nums = new int[]{0};
		int[] nums = new int[]{-2, -1};
		System.out.println(lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		int[] record = new int[nums.length];
		int maxLen = record[0] = 1;

		for(int i = 1; i < nums.length; i++) {
			int curNum = nums[i];
			record[i] = 1;

			for(int j = 0; j < i; j++) {
				if(nums[j] < curNum) {
					record[i] = Math.max(record[i], record[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, record[i]);
		}
		return maxLen;
	}
}
