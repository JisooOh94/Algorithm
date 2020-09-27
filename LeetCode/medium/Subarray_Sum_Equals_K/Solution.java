package medium.Subarray_Sum_Equals_K;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Runtime : 14ms(62.35%)
 * Memory : 45.2mb(23.50%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1};
		int k = 0;
		System.out.println(subarraySum(nums, k));
	}
	public int subarraySum(int[] nums, int k) {
		int cnt = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] sumArr = new int[nums.length];
		int curSum = 0;
		for(int i = nums.length - 1; 0 <= i; i--) {
			curSum += nums[i];
			sumArr[i] = curSum;
			List<Integer> idxList = map.get(curSum);
			if(idxList == null) {
				idxList = new LinkedList<>();
				idxList.add(i);
				map.put(curSum, idxList);
			} else {
				idxList.add(i);
			}
			if(curSum == k) cnt++;
		}


		for(int i = 0; i < sumArr.length; i++) {
			int needNum = sumArr[i] - k;
			List<Integer> needNumIdxList = map.getOrDefault(needNum, Collections.emptyList());
			for(int idx : needNumIdxList) {
				if(idx <= i) break;
				cnt++;
			}
		}
		return cnt;
	}
}
