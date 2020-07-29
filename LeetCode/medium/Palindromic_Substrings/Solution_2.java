package medium.Palindromic_Substrings;

import org.junit.Test;

/**
 * Runtime : 3ms(82.45%)
 * Memory : 37.6mb(65.23%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		String s = "abcdefgfe";
		System.out.println(countSubstrings(s));
	}

	public int countSubstrings(String s) {
		int palindromeCnt = 0;
		for(int front = 0; front < s.length() - 1; front++) {
			int cur = front;
			int next = cur + 1;
			while(0<= cur && next < s.length()) {
				if(s.charAt(cur--) != s.charAt(next++)) break;
				palindromeCnt++;
			}
			cur = front;
			int doubleNext = front + 2;
			while(0 <= cur && doubleNext < s.length()) {
				if(s.charAt(cur--) != s.charAt(doubleNext++)) break;
				palindromeCnt++;
			}
		}

		return palindromeCnt + s.length();
	}
}
