package LeetCode.ThreeSum;

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
		List<List<Integer>> resultList = new LinkedList<List<Integer>>();
		Set<Integer> firstVisited = new HashSet<Integer>();

		for(int x = 0; x < nums.length - 2; x++) {
			if(firstVisited.contains(nums[x])) continue;

			Set<Integer> secondVisited = new HashSet<Integer>();

			for(int y = x + 1; y < nums.length - 1; y++) {
				if(firstVisited.contains(nums[y]) || secondVisited.contains(nums[y])) continue;

				Set<Integer> thirdVisited = new HashSet<Integer>();

				for(int z = y + 1; z < nums.length; z++) {
					if(firstVisited.contains(nums[z]) || secondVisited.contains(nums[z]) || thirdVisited.contains(nums[z])) continue;
					if(nums[x] + nums[y] + nums[z] == 0) {
						resultList.add(Arrays.asList(nums[x], nums[y], nums[z]));
					}
					thirdVisited.add(nums[z]);
				}
				secondVisited.add(nums[y]);
			}
			firstVisited.add(nums[x]);
		}

		return resultList;
	}
}
