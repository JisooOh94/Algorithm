package medium.Maximum_Swap;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 35.9mb(52.60%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int num = 9973;
		System.out.println(maximumSwap(num));
	}

	private void swap(char[] nums, int left, int right) {
		char temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public int maximumSwap(int num) {
		char[] nums = String.valueOf(num).toCharArray();

		int maxIdx = nums.length - 1;
		String maxNum = null;

		for(int i = maxIdx - 1; 0 <= i; i--) {
			if(nums[maxIdx] < nums[i]) maxIdx = i;
			else if(nums[i] < nums[maxIdx]) {
				swap(nums, i, maxIdx);
				maxNum = String.valueOf(nums);
				swap(nums, i, maxIdx);
			}
		}

		return maxNum == null ? num : Integer.parseInt(maxNum);
	}
}
