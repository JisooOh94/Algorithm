package medium.Longest_Common_Subsequence;

import org.junit.Test;

/**
 * Runtime : 39ms(8.03%)
 * Memory : 44.1mb(10.25%)
 */
public class Solution {
	@Test
	public void execute() {
//		String s1 = "abcde"; String s2 = "ace";
		String s1 = "abc"; String s2 = "def";
		System.out.println(longestCommonSubsequence(s1, s2));
	}
	private int recursion(String s1, String s2, int idx_1, int idx_2, int[][] record) {
		if(idx_1 == s1.length() || idx_2 == s2.length()) return 0;
		else if(record[idx_1][idx_2] != 0) return record[idx_1][idx_2];

		int maxLength = s1.charAt(idx_1) == s2.charAt(idx_2) ? 1 + recursion(s1, s2, idx_1 + 1, idx_2 + 1, record) : Math.max(recursion(s1, s2, idx_1 + 1, idx_2, record), recursion(s1, s2, idx_1, idx_2 + 1, record));

		record[idx_1][idx_2] = maxLength;
		return maxLength;
	}
	public int longestCommonSubsequence(String s1, String s2) {
		int[][] record = new int[s1.length()][s2.length()];
		return recursion(s1, s2, 0, 0, record);
	}
}
