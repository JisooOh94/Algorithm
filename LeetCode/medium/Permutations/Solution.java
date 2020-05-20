package medium.Permutations;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;

/**
 * Runtime : 0ms(100.0%)
 * Memory : 40mb(5.68%)
 */
public class Solution implements Predicate<List<List<Integer>>, Object> {
	public List<List<Integer>> test(Object... params) {
		return permute((int[])params[0]);
	}

	public List<List<Integer>> permute(int[] nums) {
		if(nums == null) {
			return Collections.EMPTY_LIST;
		} else if(nums.length == 1) {
			return Arrays.asList(Arrays.asList(nums[0]));
		}

		List<List<Integer>> resultList = new LinkedList<>();
		recursion(nums, 0, resultList);

		return resultList;
	}

	private void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}

	private void recursion(int[] nums, int idx, List<List<Integer>> resultList) {
		if(idx == nums.length - 1) {
			List<Integer> list = new LinkedList<>();
			for(int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			resultList.add(list);
			return;
		}

		for(int i = idx; i < nums.length; i++) {
			swap(nums, idx, i);
			recursion(nums, idx + 1, resultList);
			swap(nums, idx, i);
		}
	}
}
