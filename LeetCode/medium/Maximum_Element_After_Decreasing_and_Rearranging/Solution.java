package medium.Maximum_Element_After_Decreasing_and_Rearranging;

import java.util.Arrays;

/**
 * Runtime : 3ms(99.44%)
 * Memory : 56mb(47.43%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		int curNum = 1;
		for(int num : arr) {
			if(num < curNum) continue;
			curNum++;
		}

		return curNum - 1;
	}
}
