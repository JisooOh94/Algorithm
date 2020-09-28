package medium.Continuous_Subarray_Sum;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Runtime : 5ms(31.14%)
 * Memory : 40.2mb(45.03%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[] nums = new int[]{23, 2, 6, 4, 7}; int k = 6;
//		int[] nums = new int[]{23,6,9}; int k = 6;
		int[] nums = new int[]{1, 1}; int k = -1;
		System.out.println(checkSubarraySum(nums, k));
	}
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length == 0) return false;
		int prev = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == 0 && prev == 0) return true;
			prev = nums[i];
		}

		if(k == 0) return false;

		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] modArr = new int[nums.length];
		int curSum = 0;
		for(int i = nums.length - 1; 0 <= i; i--) {
			curSum += nums[i];
			modArr[i] = curSum % k;
			if(modArr[i] == 0 && i != nums.length - 1) return true;
			List<Integer> idxList = map.get(curSum % k);
			if(idxList == null) {
				idxList = new LinkedList<>();
				idxList.add(i);
				map.put(curSum % k, idxList);
			} else {
				idxList.add(i);
			}
		}

		for(int i = 0; i < modArr.length; i++) {
			int needNum = modArr[i];
			List<Integer> needNumIdxList = map.getOrDefault(needNum, Collections.emptyList());
			for(int idx : needNumIdxList) {
				if(idx <= i + 1) break;
				return true;
			}
		}
		return false;
	}
}
