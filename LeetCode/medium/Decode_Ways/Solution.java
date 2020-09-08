package medium.Decode_Ways;

import org.junit.Test;

/**
 * Runtime : 1ms(98.60%)
 * Memory : 37.5mb(95.59%)
 */
public class Solution {
	@Test
	public void execute() {
//		String s = "226";
//		String s = "12";
		String s = "110";
		System.out.println(numDecodings(s));
	}
	private int recursion(int idx, String s, Integer[] record) {
		if(idx == s.length()) return 1;
		else if(record[idx] != null) return record[idx];

		int cnt = 0;
		if(idx + 1 < s.length() && s.charAt(idx + 1) == '0') {
			cnt += recursion(idx + 2, s, record);
		} else {
			cnt += recursion(idx + 1, s, record);
			if (!(idx + 2 < s.length() && s.charAt(idx + 2) == '0') && idx + 1 < s.length() && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && '1' <= s.charAt(idx + 1) && s.charAt(idx + 1) <= '6'))) cnt += recursion(idx + 2, s, record);
		}

		record[idx] = cnt;
		return cnt;
	}
	public int numDecodings(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0' && (i == 0 || (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2'))) return 0;
		}
		Integer[] record = new Integer[s.length()];
		return recursion(0, s, record);
	}
}
