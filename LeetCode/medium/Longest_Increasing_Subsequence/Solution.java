package medium.Longest_Increasing_Subsequence;

import org.junit.Test;

/**
 * Runtime : 19ms(27.26%)
 * Memory : 38.2mb(45.60%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}
	private int recursion(int curIdx, int[] nums, Integer[] record) {
		if(record[curIdx] != null) return record[curIdx];

		int curNum = nums[curIdx];
		int maxLen = 1;

		for(int i = curIdx; i < nums.length; i++) {
			if(curNum < nums[i]) {
				int curLen = 1 + recursion(i, nums, record);
				maxLen = Math.max(maxLen, curLen);
			}
		}

		record[curIdx] = maxLen;
		return maxLen;
	}
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int maxLen = 1;
		Integer[] record = new Integer[nums.length];
		for(int i = 0; i < nums.length; i++) {
			maxLen = Math.max(maxLen, recursion(i, nums, record));
		}
		return maxLen;
	}
}
