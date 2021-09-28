package medium.Maximum_Sum_Obtained_of_Any_Permutation;

import java.util.Arrays;

/**
 * Runtime : 18ms(90.23%)
 * Memory : 75mb(71.26%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Answer {
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		int[] frequency = new int[nums.length ];

		for(int[] request : requests) {
			frequency[request[0]] += 1;
			if(request[1] + 1 < nums.length)
				frequency[request[1] + 1] -= 1;
		}

		for(int i = 1; i < frequency.length; i++) {
			frequency[i] += frequency[i - 1];
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
