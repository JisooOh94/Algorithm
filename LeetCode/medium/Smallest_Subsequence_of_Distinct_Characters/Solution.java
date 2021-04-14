package medium.Smallest_Subsequence_of_Distinct_Characters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;
import javafx.util.Pair;

public class Solution {
	@Test
	public void execute() {
		String s= "ecbacba";
		System.out.println(smallestSubsequence(s));
	}
	public String smallestSubsequence(String s) {
		List<Integer>[] idxList = new LinkedList[26];
		for(int i = 0; i < s.length(); i++) {
			if(idxList[s.charAt(i) - 'a'] == null) idxList[s.charAt(i) - 'a'] = new LinkedList<>();
			idxList[s.charAt(i) - 'a'].add(i);
		}

		int minIdx = 0;
		int maxIdx = 9999;
		for(int i = 0; i < 26; i++) {
			if(idxList[i] != null) {
				maxIdx = Math.min(((LinkedList<Integer>)idxList[i]).getLast(), maxIdx);
			}
		}

		PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : e1.getValue() < e2.getValue() ? -1 : 0);
		for(int i = 0; i < 26; i++) {
			if(idxList[i] != null) {
				for(Iterator<Integer> iter = idxList[i].iterator(); iter.hasNext();) {
					int idx = iter.next();
					if(maxIdx < idx) {
						queue.offer(new Pair<>((char)(i + 'a'), idx));
						break;
					} else if(minIdx <= idx && idx <= maxIdx) {
						minIdx = idx;
						queue.offer(new Pair<>((char)(i + 'a'), idx));
						break;
					}
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		while(!queue.isEmpty()) builder.append(queue.poll().getKey());
		return builder.toString();
	}
}
