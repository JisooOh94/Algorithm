package LeetCode.Longest_Palindromic_Substring;

import util.Predicate;

/**
 * Time Compelxity : O(n^2)
 */
public class Solution implements Predicate<String, Object> {
	public String test(Object... params) {
		return longestPalindrome((String)params[0]);
	}

	public static String longestPalindrome(String sample) {
		if(sample == null || sample.length() > 1000) {
			return null;
		} else if(sample.length() <= 1) {
			return sample;
		}

		String pelindrome = "";
		for(int forwardIdx = 0; forwardIdx <= sample.length() - pelindrome.length() - 1; forwardIdx++) {
			for(int backwardIdx = sample.length() - 1; pelindrome.length() + forwardIdx <= backwardIdx; backwardIdx--) {
				int length = (backwardIdx - forwardIdx + 1);
				int mid = forwardIdx + length/2;

				boolean isPelindrome = true;
				for(int innerIdx = 0; forwardIdx + innerIdx < mid; innerIdx++) {
					if(sample.charAt(forwardIdx + innerIdx) != sample.charAt(backwardIdx - innerIdx)) {
						isPelindrome = false;
						break;
					}
				}

				if(isPelindrome) {
					pelindrome = sample.substring(forwardIdx, backwardIdx + 1);
					break;
				}
			}
		}

		return pelindrome;
	}
}
