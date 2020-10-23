package medium.Minimum_Time_to_Collect_All_Apples_in_a_Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 28ms(80.52%)
 * Memory : 83.5mb(5.17%)
 */
public class Solution {
	private int recursion (int from, int cur, List<Boolean> hasApple, List<Integer>[] edges) {
		int dist = 0;
		for(int next : edges[cur]) {
			if(next == from) continue;
			dist += recursion(cur, next, hasApple, edges);
		}
		if(hasApple.get(cur) || dist != 0) {
			return dist + 2;
		} else {
			return 0;
		}
	}
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		List<Integer>[] edgeList = new LinkedList[n];
		for(int[] edge : edges) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
		}

		int result = recursion(-1, 0, hasApple, edgeList);
		return result != 0 ? result - 2 : result;
	}
}
