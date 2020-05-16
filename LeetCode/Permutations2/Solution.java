package Permutations2;

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

	public static List<List<Integer>> permute(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Collections.EMPTY_LIST;
		} else if(nums.length == 1) {
			return Arrays.asList(Arrays.asList(nums[0]));
		}

		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		List<List<Integer>> resultList = new LinkedList<>();
		recursion(nums, 0, visited, resultList);

		return resultList;
	}

	private static void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}

	private static void recursion(int[] nums, int idx, boolean[] visited, List<List<Integer>> resultList) {
		if(idx == nums.length - 1) {
			List<Integer> list = new LinkedList<>();
			for(int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			resultList.add(list);
			return;
		}

		for(int i = idx; i < nums.length; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			swap(nums, idx, i);
			recursion(nums, idx + 1, visited, resultList);
			swap(nums, idx, i);
			visited[i] = false;
		}
	}
}
