package medium.Split_Two_Strings_to_Make_Palindrome;

import org.junit.Test;

/**
 * Runtime : 15ms(8.57%)
 * Memory : 59mb(6.12%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		String a = "xbdef";
		String b = "xecab";
		System.out.println(checkPalindromeFormation(a, b));

	}
	private boolean isPalindrome(String str) {
		int fr = 0;
		int re = str.length() - 1;
		while(fr < str.length() / 2) {
			if(str.charAt(fr) != str.charAt(re)) return false;
			fr++; re--;
		}
		return true;
	}

	public boolean checkPalindromeFormation(String str_1, String str_2) {
		if(isPalindrome(str_1) || isPalindrome(str_2)) return true;
		int length = str_1.length();

		Integer[] diffIdx = new Integer[2];
		int fr = 0;
		int re = length - 1;
		while(fr < length / 2) {
			if(diffIdx[0] == null && str_1.charAt(fr) != str_2.charAt(re)) diffIdx[0] = fr;
			if(diffIdx[1] == null && str_1.charAt(re) != str_2.charAt(fr)) diffIdx[1] = fr;
			if(diffIdx[0] != null && diffIdx[1] != null) break;
			fr++; re--;
		}
		if (diffIdx[0] == null || diffIdx[1] == null) return true;

		return isPalindrome(str_1.substring(diffIdx[0], length - diffIdx[0])) ||
				isPalindrome(str_2.substring(diffIdx[0], length - diffIdx[0])) ||
				isPalindrome(str_1.substring(diffIdx[1], length - diffIdx[1])) ||
				isPalindrome(str_2.substring(diffIdx[1], length - diffIdx[1]));
	}
}
