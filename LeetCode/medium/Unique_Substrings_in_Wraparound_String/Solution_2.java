package medium.Unique_Substrings_in_Wraparound_String;

import org.junit.Test;

/**
 * Runtime : 15ms(16.54%)
 * Memory : 41.3mb(5.26%)
 */
public class Solution_2 {

	@Test
	public void execute() {
		String p = "zab";
		System.out.println(findSubstringInWraproundString(p));
	}

	private static final int CHAR2INT = 97;
	private static final int CHAR_LEN = 26;

	public int findSubstringInWraproundString(String p) {
		if(p == null || p.length() == 0) return 0;
		else if(p.length() == 1) return 1;
		int[] max = new int[CHAR_LEN];
		int[] record = new int[p.length()];
		record[p.length() - 1] = 1;
		max[p.charAt(p.length() - 1) - CHAR2INT] = 1;
		for(int i = p.length() - 2; 0 <= i; i--) {
			record[i] = (p.charAt(i) == 'z' && p.charAt(i + 1) == 'a') || p.charAt(i) == p.charAt(i + 1) - 1 ? record[i + 1] + 1 : 1;
			max[p.charAt(i) - CHAR2INT] = Math.max(max[p.charAt(i) - CHAR2INT], record[i]);
		}

		int totalCnt = 0;
		for(int num : max) {
			totalCnt += num;
		}
		return totalCnt;
	}
}
