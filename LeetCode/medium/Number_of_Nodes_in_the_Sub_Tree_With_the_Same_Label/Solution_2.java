package medium.Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Runtime : 174ms(15.93%)
 * Memory : 497.7 b(18.58%)
 */
public class Solution_2 {
	int[] result;
	private Map<Character, Integer> recursion(int cur, int parent, List<Integer>[] edges, char[] labels) {
		Map<Character, Integer> curMap = new HashMap<>();
		curMap.put(labels[cur], 1);

		if(edges[cur] != null) {
			for (int child : edges[cur]) {
				if (child == parent) continue;
				Map<Character, Integer> childMap = recursion(child, cur, edges, labels);
				childMap.forEach((k, v) -> curMap.merge(k, v, Integer::sum));
			}
		}

		result[cur] = curMap.get(labels[cur]);
		return curMap;
	}

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		result = new int[n];
		boolean[] visited = new boolean[n];
		List<Integer>[] edgeList = new LinkedList[n];

		visited[0] = true;
		for(int[] edge : edges) {
			int parent = visited[edge[0]] ? edge[0] : edge[1];
			int child = visited[edge[0]] ? edge[1] : edge[0];
			if(edgeList[parent] == null) edgeList[parent] = new LinkedList<>();
			edgeList[parent].add(child);
			visited[child] = true;
		}

		recursion(0, -1, edgeList, labels.toCharArray());
		return result;
	}
}
