package medium.Ways_to_Make_a_Fair_Array;

/**
 * Runtime : 10ms(32.61%)
 * Memory : 52.5mb(65.36%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int waysToMakeFair(int[] nums) {
		int[] left = new int[2];
		int[] right = new int[2];
		for(int i = 0; i < nums.length; i++) {
			right[i % 2] += nums[i];
		}

		int removal = 0;
		for(int i = 0; i < nums.length; i++) {
			right[i % 2] -= nums[i];
			if(left[i % 2] + right[(i + 1) % 2] == left[(i + 1) % 2] + right[i % 2]) removal++;
			left[i % 2] += nums[i];
		}
		return removal;
	}
}
