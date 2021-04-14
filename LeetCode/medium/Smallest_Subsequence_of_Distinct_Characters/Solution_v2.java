package medium.Smallest_Subsequence_of_Distinct_Characters;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;
import javafx.util.Pair;

/**
 * Runtime : 4ms(24.20%)
 * Memory : 37.6mb(14.58%)
 * Time Complexity : O(n^2)
 * Subject : greedy
 */
public class Solution_v2 {
	@Test
	public void execute() {
		String s= "ecbacba";
		System.out.println(smallestSubsequence(s));
	}

	public String smallestSubsequence(String s) {
		PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : e1.getValue() < e2.getValue() ? -1 : 0);
		LinkedList<Integer>[] idxList = new LinkedList[26];
		for(int i = 0; i < s.length(); i++) {
			if(idxList[s.charAt(i) - 'a'] == null) idxList[s.charAt(i) - 'a'] = new LinkedList<>();
			idxList[s.charAt(i) - 'a'].add(i);
		}

		List<Integer> leftWords = new LinkedList<>();
		for(int i = 0; i < idxList.length; i++) {
			if(idxList[i] != null) leftWords.add(i);
		}

		int minIdx = -1;
		while(!leftWords.isEmpty()) {
			for(int i = 0; i < leftWords.size(); i++) {
				int curWord = leftWords.get(i);
				int curMinIdx = idxList[curWord].getFirst();
				while(curMinIdx < minIdx) {
					idxList[curWord].removeFirst();
					curMinIdx = idxList[curWord].getFirst();
				}
				boolean found = true;

				for(int j = i + 1; j < leftWords.size(); j++) {
					int compWord = leftWords.get(j);
					if(idxList[compWord].getLast() < curMinIdx) {
						found = false;
						break;
					}
				}

				if(found) {
					minIdx = curMinIdx;
					leftWords.remove(i);
					queue.offer(new Pair<>((char)(curWord + 'a'), curMinIdx));
					break;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		while(!queue.isEmpty()) builder.append(queue.poll().getKey());
		return builder.toString();
	}
}
