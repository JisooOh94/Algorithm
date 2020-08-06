package medium.Longest_String_Chain;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 40ms (59.48%)
 * Memory : 39.4mb (66.67%)
 */
public class Solution_3 {
	@Test
	public void execute() {
//		String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
//		String[] words = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
		String[] words = new String[]{"qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"};
		System.out.println(longestStrChain(words));
	}

	private boolean isPredecessor(String s1, String s2) {
		if(s1.length() + 1 != s2.length()) return false;

		boolean found = false;
		int idx_1 = 0, fr_idx2 = 0, re_idx2 = s2.length() - 1;

		while(idx_1 < (s1.length() % 2 == 0 ? s1.length() / 2 : s1.length() / 2 + 1)) {
			if(s1.charAt(idx_1) != s2.charAt(fr_idx2)) {
				if(found) return false;
				found = true;
				fr_idx2++;
			} else if(s1.charAt(s1.length() - idx_1 - 1) != s2.charAt(re_idx2)){
				if (found && fr_idx2 < re_idx2) return false;
				found = true;
				re_idx2--;
			} else {
				idx_1++; fr_idx2++; re_idx2--;
			}
		}
		return true;
	}

	private int recursion(int startIdx, String[] words, int[] record) {
		if(record[startIdx] != 0) return record[startIdx];
		int maxLength = 0;

		for(int i = startIdx + 1; i < words.length; i++) {
			if(isPredecessor(words[startIdx], words[i])) {
				int curLength = 1 + recursion(i, words, record);
				maxLength = Math.max(maxLength, curLength);
			}
		}
		record[startIdx] = maxLength;
		return maxLength;
	}

	public int longestStrChain(String[] words) {
		int[] record = new int[words.length];
		Arrays.sort(words, (s1, s2) -> s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 : 0);
		int max = 0;
		for(int i = 0; i < words.length - 1; i++) {
			max = Math.max(max, 1 + recursion(i, words, record));
		}
		return max;
	}
}
