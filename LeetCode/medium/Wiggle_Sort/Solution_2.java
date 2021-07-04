package medium.Wiggle_Sort;

import java.util.Arrays;

/**
 * Runtime : 2ms(33.98%)
 * Memory : 40.1mb(35.47%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution_2 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length - 1; i+= 2) {
			int temp = nums[i];
			nums[i] = nums[i+1];
			nums[i+1] = temp;
		}
	}
}
