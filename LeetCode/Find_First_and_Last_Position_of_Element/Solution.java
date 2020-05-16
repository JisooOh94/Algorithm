package Find_First_and_Last_Position_of_Element;

import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 42.5mb(1000.00%)
 */
public class Solution implements Predicate<String, Object> {
	private static final int[] WRONG = new int[]{-1, -1};
	public String test(Object... params) {
		int[] result = searchRange((int[])params[0], (int)params[1]);
		return result[0] + "," + result[1];
	}

	private int rearRecursion(int l, int r, int target, int[] nums) {
		if(r - l <= 1) {
			return nums[r] == target ?  r : nums[l] == target ? l : l -1;
		}

		int m = (l + r)/2;
		if(target < nums[m]) {
			return rearRecursion(l, m, target, nums);
		} else {
			return rearRecursion(m + 1, r, target, nums);
		}
	}

	private int frontRecursion(int l, int r, int target, int[] nums) {
		if(r - l <= 1) {
			return nums[l] == target ? l : nums[r] == target ? r : r + 1 ;
		}

		int m = (l + r)/2;
		if(nums[m] < target) {
			return frontRecursion(m + 1, r, target, nums);
		} else {
			return frontRecursion(l, m, target, nums);
		}
	}

	private int[] recursion(int l, int r, int target, int[] nums) {
		if(l == r) {
			return nums[l] == target ? new int[]{l, l} : WRONG;
		}

		int m = (l + r) / 2;

		if(nums[m] == target) {
			int frontIdx = frontRecursion(l, m, target, nums);
			int rearIdx = rearRecursion(m + 1, r, target, nums);

			return new int[]{frontIdx, rearIdx};
		}

		if(nums[m] < target) {
			return recursion(m + 1, r, target, nums);
		} else {
			return recursion(l, m, target, nums);
		}
	}

	private int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return WRONG;
		} else if(nums.length == 1) {
			return nums[0] == target ? new int[]{0, 0} : WRONG;
		}

		return recursion(0, nums.length - 1, target, nums);
	}
}
