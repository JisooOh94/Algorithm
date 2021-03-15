package medium.Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Runtime : 195ms(15.93%)
 * Memory : 481.9mb(18.58%)
 */
public class Solution {
	int[] result;
	private Map<Character, Integer> recursion(int cur, int parent, List<Integer>[] edges, char[] labels) {
		if(cur != 0 && edges[cur].size() == 1) {
			result[cur] = 1;
			return Collections.singletonMap(labels[cur], 1);
		}

		Map<Character, Integer> curMap = new HashMap<>();
		curMap.put(labels[cur], 1);

		for(int child : edges[cur]) {
			if(child == parent) continue;
			Map<Character, Integer> childMap = recursion(child, cur, edges, labels);
			childMap.forEach((k, v) -> curMap.merge(k, v, Integer::sum));
		}

		result[cur] = curMap.get(labels[cur]);
		return curMap;
	}

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		result = new int[n];

		List<Integer>[] edgeList = new LinkedList[n];

		for(int[] edge : edges) {

			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
		}

		recursion(0, -1, edgeList, labels.toCharArray());
		return result;
	}
}
