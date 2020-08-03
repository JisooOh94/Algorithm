package medium.Longest_String_Chain;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 81ms (27.58%)
 * Memory : 39.4mb (62.92%)
 */
public class Solution {
	@Test
	public void execute() {
//		String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
		String[] words = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
		System.out.println(longestStrChain(words));
	}

	private boolean isPredecessor(String s1, String s2) {
		if(s1.length() + 1 != s2.length()) return false;

		boolean found = false;
		int idx_1 = 0, idx_2 = 0;

		while(idx_1 < s1.length()) {
			if(s1.charAt(idx_1) != s2.charAt(idx_2)) {
				if(found) return false;
				found = true;
				idx_2++;
			} else {
				idx_1++; idx_2++;
			}
		}
		return true;
	}

	private int recursion(int startIdx, String[] words) {
		int maxLength = 0;

		for(int i = startIdx + 1; i < words.length; i++) {
			if(isPredecessor(words[startIdx], words[i])) {
				int curLength = 1 + recursion(i, words);
				maxLength = Math.max(maxLength, curLength);
			}
		}
		return maxLength;
	}

	public int longestStrChain(String[] words) {
		Arrays.sort(words, (s1, s2) -> s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 : 0);
		int max = 0;
		for(int i = 0; i < words.length - 1; i++) {
			max = Math.max(max, 1 + recursion(i, words));
		}
		return max;
	}
}
