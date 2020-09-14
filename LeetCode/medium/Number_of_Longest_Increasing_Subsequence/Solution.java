package medium.Number_of_Longest_Increasing_Subsequence;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,3,5,4,7};
		System.out.println(findNumberOfLIS(nums));
	}
	private static final int LEN_IDX = 0;
	private static final int CNT_IDX = 1;
	private Integer[] recursion(int curIdx, int prevIdx, int[] nums, Integer[][][] record) {
		if(curIdx == nums.length) {
			return new Integer[]{0,0};
		} else if(record[curIdx][prevIdx][LEN_IDX] != null) {
			return record[curIdx][prevIdx];
		}

		Integer[] maxInfo = recursion(curIdx + 1, prevIdx, nums, record);
		if(nums[prevIdx] < nums[curIdx]) {
			Integer[] includeMaxInfo = recursion(curIdx + 1, curIdx, nums, record);
			includeMaxInfo[LEN_IDX]++;
			includeMaxInfo[CNT_IDX] = includeMaxInfo[CNT_IDX] == 0 ? 1 : includeMaxInfo[CNT_IDX];
			if(maxInfo[LEN_IDX] == includeMaxInfo[LEN_IDX]) maxInfo[CNT_IDX] += includeMaxInfo[CNT_IDX];
			else if(maxInfo[LEN_IDX] < includeMaxInfo[LEN_IDX]) maxInfo = includeMaxInfo;
		}

		record[curIdx][prevIdx] = maxInfo;
		return maxInfo;
	}

	public int findNumberOfLIS(int[] nums) {
		Integer[][][] record = new Integer[nums.length][nums.length][2];
		Integer[] maxInfo = new Integer[]{0,0};
		for(int i = 0; i < nums.length; i++) {
			Integer[] curMaxInfo = recursion(i, i, nums, record);
			if(maxInfo[LEN_IDX] == curMaxInfo[LEN_IDX]) maxInfo[CNT_IDX] += curMaxInfo[CNT_IDX];
			else if(maxInfo[LEN_IDX] < curMaxInfo[LEN_IDX]) maxInfo = curMaxInfo;
		}
		return maxInfo[CNT_IDX];
	}
}
