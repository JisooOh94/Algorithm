package medium.Palindrome_Partitioning;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Runtime : 23ms(5.13%)
 * Memory : 63.2mb(5.23%)
 */
public class Solution {
	@Test
	public void execute() {
		String str = "aab";
		List<List<String>> result = partition(str);
		result.forEach(list -> list.forEach(System.out::println));
	}

	boolean isPalindromic(String str) {
		int length = str.length() - 1;
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(length - i)) return false;
		}

		return true;
	}

	public List<List<String>> partition(String s) {
		LinkedList<LinkedList<String>>[] palindromeList = new LinkedList[s.length()];

		for(int i = s.length() - 1; 0 <= i; i--) {
			LinkedList<LinkedList<String>> curPalindromeList = new LinkedList<>();
			for(int j = i; j < s.length(); j++) {
				String str = s.substring(i, j + 1);
				if(isPalindromic(str)) {
					if(j == s.length() - 1) {
						curPalindromeList.add(new LinkedList<>(Arrays.asList(str)));
					} else {
						LinkedList<LinkedList<String>> list = new LinkedList<>(palindromeList[j + 1].stream().map(x -> new LinkedList<>(x)).collect(Collectors.toList()));
						for(LinkedList<String> palindrome : list) {
							palindrome.addFirst(str);
						}
						curPalindromeList.addAll(list);
					}

				}
			}
			palindromeList[i] = curPalindromeList;
		}
		return (List)palindromeList[0];
	}
}
