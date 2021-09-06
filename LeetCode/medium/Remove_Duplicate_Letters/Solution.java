package medium.Remove_Duplicate_Letters;

import java.util.Stack;

import org.junit.Test;
import javafx.util.Pair;

/**
 * Runtime : 5ms(32.09%)
 * Memory : 39.9mb(13.24%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		String s = "cbacdcbc";
		System.out.println(removeDuplicateLetters(s));
	}
	public String removeDuplicateLetters(String s) {
		int[] lastIdx = new int[26];
		boolean[] added = new boolean[26];
		Stack<Pair<Character, Integer>> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) lastIdx[s.charAt(i) - 'a'] = i;

		for (int i = 0; i < s.length(); i++) {
			if (added[s.charAt(i) - 'a']) continue;
			while (!stack.isEmpty()) {
				Pair<Character, Integer> pair = stack.peek();
				if (pair.getKey() < s.charAt(i) || pair.getValue() == lastIdx[pair.getKey() - 'a'] || lastIdx[pair.getKey() - 'a'] < i) break;
				stack.pop();
				added[pair.getKey() - 'a'] = false;
			}
			stack.push(new Pair<>(s.charAt(i), i));
			added[s.charAt(i) - 'a'] = true;
		}

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) builder.append(stack.pop().getKey());
		return builder.reverse().toString();
	}
}
