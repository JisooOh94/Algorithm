package easy.Two_Sum;

import java.util.Arrays;

public class Solution_2 {
	public int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);

		for(int i = 0; i < nums.length; i++) {
			int needNum = target - nums[i];
			int needNumIdx = Arrays.binarySearch(nums, needNum);
			if (needNumIdx != -1) {
				return new int[]{i, needNumIdx};
			}
		}
		return null;
	}
}
