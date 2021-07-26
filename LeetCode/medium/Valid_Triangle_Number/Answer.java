package medium.Valid_Triangle_Number;

import java.util.Arrays;

/**
 * Runtime : 29ms(89.44$)
 * Memory : 38.7mb(40.03%)
 * Time Complexity : O(n^2)
 * Subject : greedy
 */
public class Answer {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int cnt = 0;

		for(int c = nums.length - 1; 2 <= c; c--) {
			int a = 0, b = c - 1;
			while(a < b) {
				if(nums[a] + nums[b] > nums[c]) {
					cnt += b - a;
					b--;
				} else {
					a++;
				}
			}
		}
		return cnt;
	}
}
