package LeetCode.FourSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import util.PerformanceUtil;
import util.Predicate;

public class Solution implements Predicate<List, Object> {
	@Override
	public List<List<Integer>> test(Object... params) {
		return fourSum((int[])params[0], (int)params[1]);
	}

	private List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> resultList = new LinkedList<>();
		Arrays.sort(nums);
		int prevA = 0;
		for(int a = 0; a < nums.length - 3; a++) {
			if(nums[a] == prevA && a != 0) {
				continue;
			} else {
				prevA = nums[a];
			}

			int prevB = 0;
			for(int b = a + 1; b < nums.length - 2; b++) {
				if(nums[b] == prevB && b != a + 1) {
					continue;
				} else {
					prevB = nums[b];
				}

				int prevC = 0;
				for(int c = b + 1; c < nums.length - 1; c++) {
					if(nums[c] == prevC && c != b + 1) {
						continue;
					} else {
						prevC = nums[c];
					}

					int prevD = 0;
					for(int d = c + 1; d < nums.length; d++) {
						if(nums[d] == prevD && d != c + 1) {
							continue;
						} else {
							prevD = nums[d];
						}

						if(nums[a] + nums[b] + nums[c] + nums[d] == target) {
							resultList.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
						}
					}
				}
			}
		}

		return resultList;
	}
}
