package LeetCode.Search_in_Rotated_Sorted_Array;

import java.util.Arrays;

import util.Predicate;

/**
 * Runtime : 0ms(100.0%)
 * Memory : 38mb(47.17%)
 */
public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return search((int[])params[0], (int)params[1]);
	}

	private int idx = -1;

	private void recursion(int[] nums, int target, int l, int r) {
		if(idx != -1 || r < l) return;

		int m = l + (r - l) / 2;

		if (nums[m] == target) {
			idx = m;
		} else {
			if (nums[m] < nums[l]) {		//left pivot
				if (target < nums[m] || nums[l] <= target) {
					recursion(nums, target, l, m - 1);
				} else {
					recursion(nums, target, m + 1, r);
				}
			} else if (nums[r] < nums[m]) {	//right pivot
				if(nums[m] < target || target <= nums[r]) {
					recursion(nums, target, m + 1, r);
				} else {
					recursion(nums, target, l, r - 1);
				}
			} else {
				int result = Arrays.binarySearch(nums, l, r + 1, target);
				idx = result < 0 ? -1 : result;
			}
		}
	}

	private int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		else if (target == nums[0]) return 0;
		else if(target == nums[nums.length - 1]) return nums.length - 1;

		recursion(nums, target, 0, nums.length - 1);
		return idx;
	}
}
