package medium.Palindromic_Substrings;

import org.junit.Test;

/**
 * Runtime : 425ms(9.06%)
 * Memory : 37.6mb(65.23%)
 */
public class Solution {
	@Test
	public void execute() {
		String s = "abcdefgfe";
		System.out.println(countSubstrings(s));
	}
	private boolean isPelindromic(String s, int startIdx, int endIdx) {
		for(int front = 0; front <= (endIdx - startIdx)/2; front++) {
			int rear = endIdx - front;
			if (s.charAt(startIdx + front) != s.charAt(rear)) return false;
		}
		return true;
	}
	public int countSubstrings(String s) {
		int palindromeCnt = 0;
		for(int front = 0; front < s.length(); front++) {
			for(int rear = front; rear < s.length(); rear++) {
				if(isPelindromic(s, front, rear)) palindromeCnt++;
			}
		}

		return palindromeCnt;
	}
}
