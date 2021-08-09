package medium.Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

/**
 * Runtime : 34ms(23.73%)
 * Memory : 56mb(5.76%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int plusSum = 0;
		int last = -1;
		for(int cur : nums) {
			if(cur <= last) {
				last++;
				plusSum += last - cur;
			} else {
				last = cur;
			}
		}
		return plusSum;
	}
}
