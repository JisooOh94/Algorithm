package medium.Maximum_Sum_Obtained_of_Any_Permutation;

import java.util.Arrays;

/**
 * Time Limit Exceed
 */
public class Solution {
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		int[] frequency = new int[nums.length ];
		for(int[] request : requests) {
			for(int i = request[0]; i <= request[1]; i++) frequency[i]++;
		}

		Arrays.sort(frequency);
		Arrays.sort(nums);
		int numIdx = nums.length - 1;
		long totalSum = 0;
		for(int i = frequency.length - 1; 0 <= i; i--) {
			if(frequency[i] == 0) break;
			totalSum += (long)nums[numIdx--] * (long)frequency[i];
		}
		return (int)(totalSum % ((long)Math.pow(10, 9) + 7L));
	}
}
