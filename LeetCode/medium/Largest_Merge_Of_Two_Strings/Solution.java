package medium.Largest_Merge_Of_Two_Strings;

import org.junit.Test;

/**
 * Runtime : 63ms(57.48%)
 * Memory : 40.4mb(40.19%)
 * Time Complexity : O(n^2)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		String word1 = "cabaa"; String word2 = "bcaaa";
//		String word1 = "abcabc"; String word2 = "abdcaba";
//		String word1 = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"; String word2 = "bbbbbbbbbbbbbbbbbbbb";
		String word1 = "abaaaaaabaababaaababaaaa";
		String word2 = "aaaaaabaaaaaabaaaab";
		String expected = "abaaaaaabaababaaababaaaaaabaaaaaabaaaabaaaa";
		String actual   = "abaaaaaabaababaaababaaaaaaaaabaaaaaabaaaaba";

		System.out.println(largestMerge(word1, word2));
	}
	private int findBigger(int idx1, int idx2, String word1, String word2) {
		while(++idx1 < word1.length() && ++idx2 < word2.length()) {
			if(word1.charAt(idx1) != word2.charAt(idx2)) return word1.charAt(idx1) > word2.charAt(idx2) ? 1 : 2;
		}
		return idx1 == word1.length() ? 2 : 1;
	}
	public String largestMerge(String word1, String word2) {
		int idx1 = 0, idx2 = 0;
		StringBuilder builder = new StringBuilder();

		while(idx1 < word1.length() && idx2 < word2.length()) {
			if(word1.charAt(idx1) > word2.charAt(idx2)) builder.append(word1.charAt(idx1++));
			else if(word2.charAt(idx2) > word1.charAt(idx1)) builder.append(word2.charAt(idx2++));
			else if(idx1 + 1 == word1.length() && idx2 + 1 == word2.length()) { builder.append(word1.charAt(idx1++)); builder.append(word2.charAt(idx2++));}
			else if(idx1 + 1 == word1.length()) builder.append(word2.charAt(idx2++));
			else if(idx2 + 1 == word2.length()) builder.append(word1.charAt(idx1++));
			else if(word2.charAt(idx2 + 1) > word1.charAt(idx1 + 1)) builder.append(word2.charAt(idx2++));
			else if(word1.charAt(idx1 + 1) > word2.charAt(idx2 + 1)) builder.append(word1.charAt(idx1++));
			else if(word1.charAt(idx1) > word1.charAt(idx1 + 1)) { builder.append(word1.charAt(idx1++)); builder.append(word2.charAt(idx2++));}
			else builder.append(findBigger(idx1, idx2, word1, word2) == 1 ? word1.charAt(idx1++) : word2.charAt(idx2++));
		}
		while (idx1 < word1.length()) builder.append(word1.charAt(idx1++));
		while (idx2 < word2.length()) builder.append(word2.charAt(idx2++));

		return builder.toString();
	}
}
