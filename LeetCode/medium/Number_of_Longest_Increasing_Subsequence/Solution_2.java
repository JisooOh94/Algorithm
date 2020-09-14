package medium.Number_of_Longest_Increasing_Subsequence;

import org.junit.Test;

public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{1,3,5,4,7};
		System.out.println(findNumberOfLIS(nums));
	}

	private int recursion(int curIdx, int prevIdx, int[] nums, Integer[][] record) {
		if(curIdx == nums.length) return 0;
		else if(record[curIdx][prevIdx] != null) return record[curIdx][];
	}

	public int findNumberOfLIS(int[] nums) {

	}
}
