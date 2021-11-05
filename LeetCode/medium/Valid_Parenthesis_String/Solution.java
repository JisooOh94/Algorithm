package medium.Valid_Parenthesis_String;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Runtime : 1ms(43.55%)
 * Memory : 37.1mb(66.49%)
 * Time Complexity : O(n)
 */
public class Solution {
	public boolean checkValidString(String s) {
		Stack<Integer> openStack = new Stack<>();
		Stack<Integer> closeStack = new Stack<>();
		Deque<Integer> starDeque = new LinkedList<>();

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(') openStack.push(i);
			else if(ch == '*') starDeque.offer(i);
			else {
				if(openStack.isEmpty()) {
					if(starDeque.isEmpty()) return false;
					else starDeque.poll();
				} else {
					openStack.pop();
				}
			}
		}

		while(!openStack.isEmpty()) {
			if(starDeque.isEmpty()) return false;
			int openIdx = openStack.pop();
			int starIdx = starDeque.pollLast();
			if(starIdx < openIdx) return false;
		}

		return true;
	}
}
