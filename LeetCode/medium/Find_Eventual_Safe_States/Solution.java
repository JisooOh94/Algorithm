package medium.Find_Eventual_Safe_States;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 26ms(32.37%)
 * Memory : 47.9mb(84.05%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] graph = new int[][]{
//				{1,2},{2,3},{5},{0},{5},{},{}
				{1,2,3,4},{1,2},{3,4},{0,4},{}
		};

		System.out.println(eventualSafeNodes(graph));
	}
	private boolean recursion(int cur, int[][] graph, boolean[] visited, Boolean[] isSafe, List<Integer> safeList) {
		if(isSafe[cur] != null) return isSafe[cur];
		else if(graph[cur].length == 0) {
			isSafe[cur] = true;
			safeList.add(cur);
			return true;
		}

		visited[cur] = true;
		for(int connected : graph[cur]) {
			if(visited[connected] || !recursion(connected, graph, visited, isSafe, safeList)) {
				isSafe[cur] = false;
				return false;
			}
		}
		visited[cur] = false;
		isSafe[cur] = true;
		safeList.add(cur);
		return true;
	}
	public List<Integer> eventualSafeNodes(int[][] graph) {
		if(graph == null || graph.length == 0) return Collections.emptyList();
		Boolean[] isSafe = new Boolean[graph.length];
		List<Integer> safeList = new LinkedList<>();

		for(int i = 0; i < graph.length; i++) {
			if(isSafe[i] == null) {
				recursion(i, graph, new boolean[graph.length], isSafe, safeList);
			}
		}

		Collections.sort(safeList);
		return safeList;
	}
}
