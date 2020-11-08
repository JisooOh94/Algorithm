package medium.Minimum_Number_of_Vertices_to_Reach_All_Nodes;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 9ms(93.58%)
 * Memory : 77.5mb(5.10%)
 */
public class Solution {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		boolean[] reachable = new boolean[n];

		for(List<Integer> edge : edges) {
			reachable[edge.get(1)] = true;
		}

		List<Integer> result = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(!reachable[i]) result.add(i);
		}

		return result;
	}
}
