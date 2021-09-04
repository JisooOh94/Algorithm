package medium.Increasing_Triplet_Subsequence;

/**
 * Runtime : 2ms(59.39%)
 * Memory : 80.6mb(57.89%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public boolean increasingTriplet(int[] nums) {
		long first = 2147483648L, second = 2147483648L;
		for (int num : nums) {
			if (second < num) return true;
			else if (first < num) second = num;
			else first = num;
		}
		return false;
	}
}
