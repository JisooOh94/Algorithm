package easy.Two_Sum;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] needNum = new int[nums.length];

		for(int i = 0; i < nums.length; i++) {
			needNum[i] = target - nums[i];
			for(int j = 0; j < i; j++) {
				if(needNum[j] == nums[i]) {
					return new int[]{j, i};
				}
			}
		}
		return null;
	}
}
