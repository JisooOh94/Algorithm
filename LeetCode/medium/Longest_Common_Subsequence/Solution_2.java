package medium.Longest_Common_Subsequence;

import org.junit.Test;

/**
 * Runtime : 13ms(53.53%)
 * Memory : 43.2mb(65.25%%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		String s1 = "abcde"; String s2 = "ace";
		String s1 = "abc"; String s2 = "def";
		System.out.println(longestCommonSubsequence(s1, s2));
	}

	public int longestCommonSubsequence(String s1, String s2) {
		int[][] record = new int[s1.length() + 1][s2.length() + 1];

		for(int i = 0; i <= s1.length(); i++) record[i][0] = 0;
		for(int i = 0; i <= s2.length(); i++) record[0][i] = 0;

		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				record[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? record[i - 1][j - 1] + 1 : Math.max(record[i - 1][j], record[i][j - 1]);
			}
		}
		return record[s1.length()][s2.length()];
	}
}
