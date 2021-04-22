package medium.Form_Array_by_Concatenating_Subarrays_of_Another_Array;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 38.6mb(99.53%)
 * Time Complexity : O(g + n)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[][] groups = new int[][]{{1,-1,-1},{3,-2,0}}; int[] nums = new int[]{1,-1,0,1,-1,-1,3,-2,0};

		int[][] groups = new int[][]{{21,22,21,22,21,30}};
		int[] nums = new int[]{21,22,21,22,21,22,21,30};

		System.out.println(canChoose(groups, nums));
	}
	public boolean canChoose(int[][] groups, int[] nums) {
		int found = 0;
		int numsIdx = 0;
		for (int[] group : groups) {
			while(numsIdx <= nums.length - group.length) {
				while(numsIdx < nums.length && nums[numsIdx] != group[0]) numsIdx++;
				if(numsIdx == nums.length) return found == groups.length;

				int compIdx = 1;
				Integer nextNumsIdx = null;
				while (compIdx < group.length) {
					int curNumsIdx = numsIdx + compIdx;
					if(curNumsIdx == nums.length) return found == groups.length;
					if(nums[curNumsIdx] == group[0] && nextNumsIdx == null) nextNumsIdx = curNumsIdx;
					if(nums[curNumsIdx] != group[compIdx]) break;
					compIdx++;
				}

				if (compIdx == group.length) {
					found++;
					numsIdx += compIdx;
					break;
				} else {
					numsIdx = nextNumsIdx != null ? nextNumsIdx : numsIdx + compIdx + 1;
				}
			}
		}
		return found == groups.length;
	}
}
