package medium.Number_of_Operations_to_Make_Network_Connected;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 15ms(38.76%)
 * Memory : 56.3mb(5.70%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] edges = new int[][]{
				{0,1},{0,2},{0,3},{1,2}
		};
		int n = 6;

//		int[][] edges = new int[][]{
//				{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}
//		};
//		int n = 11;

		System.out.println(makeConnected(n, edges));
	}

	private int recursion (int cur, int prev, int label, boolean[] visited, List<Integer>[] edges) {
		visited[cur] = true;
		if(edges[cur] == null) return 0;
		int extraEdgeCnt = 0;
		for(int next : edges[cur]) {
			if(next == prev) continue;
			else if(visited[next]){
				if(cur < next) extraEdgeCnt++;
			}
			else extraEdgeCnt += recursion(next, cur, label, visited, edges);
		}
		return extraEdgeCnt;
	}
	public int makeConnected(int n, int[][] edges) {
		List<Integer>[] edgeList = new LinkedList[n];
		for(int[] edge : edges) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		int labelIdx = 0;
		int extraEdgeCnt = 0;
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				extraEdgeCnt += recursion(i, -1, labelIdx++, visited, edgeList);
			}
		}
		return extraEdgeCnt < labelIdx - 1 ? -1 : labelIdx - 1;
	}
}
