package medium.Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 3ms(70.57%)
 * Memory : 39.3mb(6.06%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 4;
		int[][] edges = new int[][]{
				{2,3},{1,2},{1,3}
		};

		System.out.println(countComponents(n, edges));
	}
	private void mark(int cur, List<Integer>[] edges, boolean[] visited) {
		if(visited[cur]) return;

		visited[cur] = true;
		if(edges[cur] != null) {
			for (int neighbor : edges[cur]) {
				mark(neighbor, edges, visited);
			}
		}
	}
	public int countComponents(int n, int[][] edges) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else if(edges == null || edges.length == 0) return n;
		boolean[] visited = new boolean[n];
		List<Integer>[] edgeList = new LinkedList[n];
		for(int[] edge : edges) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);

			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[1]].add(edge[0]);
		}

		int componentCnt = 0;
		for(int cur = 0; cur < n; cur++) {
			if(!visited[cur]) {
				componentCnt++;
				mark(cur, edgeList, visited);
			}
		}
		return componentCnt;
	}
}
