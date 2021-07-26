package medium.Valid_Triangle_Number;

import java.util.Arrays;

/**
 * Runtime : 861ms(16.00%)
 * Memory : 38.6mb(69.71%)
 * Time Complexity: O(n^3)
 * Subject : greedy
 */
public class Solution {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int cnt = 0;
		for(int a = 0; a < nums.length - 2; a++) {
			if(nums[a] == 0) continue;
			for(int b = a + 1; b < nums.length - 1; b++) {
				for(int c = b + 1; c < nums.length; c++) {
					if(nums[a] + nums[b] <= nums[c]) break;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
