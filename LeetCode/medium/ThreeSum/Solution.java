package medium.ThreeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.Predicate;

public class Solution implements Predicate<List<List<Integer>>, Object> {
	public List<List<Integer>> test(Object... params) {
		return threeSum((int[]) params[0]);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> resultList = new LinkedList<List<Integer>>();
		Set<Integer> firstVisited = new HashSet<Integer>();

		for(int x = 0; x < nums.length - 2; x++) {
			if(firstVisited.contains(nums[x])) continue;

			Set<Integer> secondVisited = new HashSet<Integer>();

			for(int y = x + 1; y < nums.length - 1; y++) {
				if(firstVisited.contains(nums[y]) || secondVisited.contains(nums[y])) continue;

				int targetNum = (nums[x] + nums[y]) * -1;

				if(firstVisited.contains(targetNum) || secondVisited.contains(targetNum)) continue;

				int fromIdx = y + 1;

				if(Arrays.binarySearch(nums, fromIdx, nums.length, targetNum) >= 0) {
					resultList.add(Arrays.asList(nums[x], nums[y], targetNum));
				}

				secondVisited.add(nums[y]);
			}
			firstVisited.add(nums[x]);
		}

		return resultList;
	}
}
