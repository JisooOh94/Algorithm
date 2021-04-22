package medium.Form_Array_by_Concatenating_Subarrays_of_Another_Array;

public class Solution {
	public boolean canChoose(int[][] groups, int[] nums) {
		int found = 0;
		int idx = 0;
		for (int[] group : groups) {
			int compIdx = 0;
			while (idx < nums.length && compIdx < group.length) {
				compIdx = group[compIdx] == nums[idx++] ? compIdx + 1 : 0;
			}

			if (compIdx == group.length) found++;
			if (idx == nums.length) break;
		}
		return found == groups.length;
	}
}
