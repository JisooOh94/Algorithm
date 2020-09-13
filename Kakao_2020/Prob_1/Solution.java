package Prob_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution {
	@Test
	public void test() {
//		String newId = "...!@BaT#*..y.abcdefghijklm";
		String newId = 	"=.=";
		System.out.println(solution(newId));
	}
	public String solution(String new_id) {
		LinkedList<Character> queue = new LinkedList<>();
		char prev = ' ';
		for(int i = 0; i < new_id.length(); i++) {
			char ch = new_id.charAt(i);
			if(('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'z') || ch == '-' || ch == '_' || (ch == '.' && prev != '.')) {
				queue.add(ch);
				prev = ch;
			}
			else if('A' <= ch && ch <= 'Z') {
				prev = (char)((int)ch + 32);
				queue.add(prev);
			}
		}

		while (!queue.isEmpty() && queue.getFirst() == '.') queue.removeFirst();
		while (!queue.isEmpty() && queue.getLast() == '.') queue.removeLast();

		if(15 < queue.size()) {
			queue.subList(15, queue.size()).clear();
			while (!queue.isEmpty() && queue.getLast() == '.') queue.removeLast();
		}

		if(queue.size() == 0) {
			return "aaa";
		} else if(queue.size() == 1) {
			return queue.getLast().toString() + queue.getLast().toString() + queue.getLast().toString();
		} else if(queue.size() == 2) {
			return queue.getFirst().toString() + queue.getLast().toString() + queue.getLast().toString();
		}

		StringBuilder builder = new StringBuilder();
		for(char ch : queue) builder.append(ch);
		return builder.toString();
	}
}
