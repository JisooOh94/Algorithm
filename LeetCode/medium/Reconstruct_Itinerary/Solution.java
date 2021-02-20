package medium.Reconstruct_Itinerary;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Runtime : 7ms(44.20%)
 * Memory : 39.6mb(76.75%)
 * Time Complexity : O(n^2)
 */
public class Solution {
	private static final int FROM = 0;
	private static final int TO = 1;
	private static final String START = "JFK";
	private int totalPast;

	private boolean recursion(String cur, LinkedList<String> past, Map<String, List<String>> edges) {
		past.addLast(cur);
		if(past.size() == totalPast) return true;

		List<String> neighborList = edges.get(cur);
		if(neighborList != null) {
			for(int i = 0; i < neighborList.size(); i++) {
				String next = neighborList.remove(i);
				if(recursion(next, past, edges)) return true;
				neighborList.add(i, next);
			}
		}

		past.removeLast();
		return false;
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		if(tickets.size() == 1) return tickets.get(0);
		totalPast = tickets.size() + 1;
		Map<String, List<String>> edges = new HashMap<>();
		for(List<String> edge : tickets) {
			if(!edges.containsKey(edge.get(FROM))) edges.put(edge.get(FROM), new LinkedList<>(Arrays.asList(edge.get(TO))));
			else edges.get(edge.get(FROM)).add(edge.get(TO));
		}
		for(List<String> edge : edges.values()) Collections.sort(edge);

		LinkedList<String> past = new LinkedList<>();

		recursion(START, past, edges);
		return past;
	}
}
