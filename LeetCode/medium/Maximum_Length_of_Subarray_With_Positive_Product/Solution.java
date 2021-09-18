package medium.Maximum_Length_of_Subarray_With_Positive_Product;

/**
 * Runtime : 5ms(47.99%)
 * Memory : 82.1mb(7.33%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int getMaxLen(int[] nums) {
		Integer first = null, last = null;
		int start = 0, cnt = 0, len = 0, maxLen = 0;

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				maxLen = Math.max(cnt % 2 == 0 ? len : Math.max(last, len - first - 1), maxLen);
				first = last = null;
				cnt = len = 0;
				start = i + 1;
				continue;
			}
			if(nums[i] < 0) {
				cnt++;
				last = i - start;
				if(first == null) first = i - start;
			}
			len++;
		}
		if(len != 0) maxLen = Math.max(cnt % 2 == 0 ? len : Math.max(last, len - first - 1), maxLen);
		return maxLen;
	}
}
