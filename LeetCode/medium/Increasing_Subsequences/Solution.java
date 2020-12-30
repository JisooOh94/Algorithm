package medium.Increasing_Subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Runtime : 34ms(8.03%)
 * Memory : 48.2mb(23.80%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		List<List<Integer>> resultList = findSubsequences(nums);
		Collections.sort(resultList, this::comparator);
	}

	private int comparator(List<Integer> source, List<Integer> target) {
		for(int i = 0; i < Math.min(source.size(), target.size()); i++) {
			if(source.get(i) < target.get(i)) return -1;
			else if(source.get(i) > target.get(i)) return 1;
		}
		if(source.size() < target.size()) return -1;
		else if(source.size() > target.size()) return 1;
		else return 0;
	}
	private void recursion(int cur, int lastNum, int[] nums, ArrayList<Integer> subSeq, String key, Map<String, List<Integer>> subSeqGroup) {
		if(cur == nums.length) return;
		recursion(cur + 1, lastNum, nums, subSeq, key, subSeqGroup);

		if(lastNum <= nums[cur]) {
			ArrayList<Integer> subSeqCpy = (ArrayList<Integer>) subSeq.clone();
			subSeqCpy.add(nums[cur]);
			if(subSeqCpy.size() > 1) subSeqGroup.put(key + nums[cur] + ".", subSeqCpy);

			recursion(cur + 1, nums[cur], nums, subSeqCpy, key + nums[cur] + ".", subSeqGroup);
		}
	}
	public List<List<Integer>> findSubsequences(int[] nums) {
		Map<String, List<Integer>> subSeqGroup = new HashMap<>();
		recursion(0, -101, nums, new ArrayList<>(), "", subSeqGroup);
		List<List<Integer>> resultList = new LinkedList<>();
		for(List<Integer> list : subSeqGroup.values()) {
			resultList.add(list);
		}
		return resultList;
	}
}
