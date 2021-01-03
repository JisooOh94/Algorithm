package medium.Smallest_String_With_Swaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 2264ms(5.04%)
 * Memory : 89.2mb(47.22%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		String s = "dcab";
//		List<List<Integer>> pairs = Arrays.asList(
//				Arrays.asList(0, 3),
//				Arrays.asList(1,2)
//		);
		List<List<Integer>> pairs = Arrays.asList(
				Arrays.asList(0, 3),
				Arrays.asList(1,2),
				Arrays.asList(0,2)
		);
		System.out.println(smallestStringWithSwaps(s, pairs));
	}


	private int getParent(int cur, Integer[] parentInfo) {
		while(parentInfo[cur] != null && cur != parentInfo[cur]) cur = parentInfo[cur];
		return cur;
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		Integer[] parentInfo = new Integer[s.length()];

		for(List<Integer> pair : pairs) {
			Collections.sort(pair);
			int parent = getParent(pair.get(0), parentInfo);
			int child = getParent(pair.get(1), parentInfo);

			parentInfo[child] = parent;
		}

		Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

		for(int i = 0; i < s.length(); i++) {
			int parentIdx = getParent(i, parentInfo);
			parentInfo[i] = parentIdx;
			map.putIfAbsent(parentIdx, new PriorityQueue<>());
			map.get(parentIdx).offer(s.charAt(i));
		}

		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			builder.append(map.get(parentInfo[i]).poll());
		}
		return builder.toString();
	}
}
