package study.Two_Sum;

import java.util.HashMap;

/**
 * O(n)
 */
public class Solution_3 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> needNumMap = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			int needNum = target - nums[i];
			if (needNumMap.containsKey(needNum)) {
				return new int[]{i, needNumMap.get(needNum)};
			} else {
				needNumMap.put(nums[i], i);
			}
		}
		return null;
	}
}
