package medium.Is_Graph_Bipartite;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.1mb(94.28%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] graph = new int[][]{
//				{1,3},{0,2},{1,3},{0,2}
				{1},{0},{4},{4},{2,3}
		};

		System.out.println(isBipartite(graph));
	}
	private boolean recursion(int cur, int curGroup, int[][] graph, Integer[] group) {
		for(int neighbor : graph[cur]) {
			if(group[neighbor] != null && group[neighbor] == curGroup) return false;
			else if(group[neighbor] == null) {
				group[neighbor] = curGroup * -1;
				if(!recursion(neighbor, curGroup * -1, graph, group)) return false;
			}
		}
		return true;
	}
	public boolean isBipartite(int[][] graph) {
		Integer[] group = new Integer[graph.length];
		for(int i = 0; i < graph.length; i++) {
			if(graph[i].length != 0 && group[i] == null) {
				group[i] = 1;
				if(!recursion(i, 1, graph, group)) return false;
			}
		}
		return true;
	}
}
