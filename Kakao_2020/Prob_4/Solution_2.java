package Prob_4;

import java.util.LinkedList;
import java.util.List;

public class Solution_2 {
	private static int target_1 = 0;
	private static int target_2 = 0;
	private static final int TOGETHER = -1;
	private int recursion (int curPos, List<int[]>[] edges, int target, boolean[] visited) {
		if(curPos == target) return 0;

		int minCost = 99999;
		for(int[] edge : edges[curPos]) {
			if(!visited[edge[0]]) {
				int nextPos = edge[0];
				int curCost = edge[1];
				visited[nextPos] = true;

				if(target == TOGETHER) {
					curCost += Math.min(recursion(nextPos, edges, target_1, visited)  + recursion(nextPos, edges, target_2, visited), recursion(nextPos, edges, TOGETHER, visited));
				} else {
					curCost += recursion(nextPos, edges, target, visited);
				}
				minCost = Math.min(minCost, curCost);
				visited[nextPos] = false;
			}
		}

		return minCost;
	}

	public int solution(int n, int s, int a, int b, int[][] fares) {
		target_1 = a - 1;
		target_2 = b - 1;

		boolean[] visited = new boolean[n];
		visited[s - 1] = true;
		List<int[]>[] edges = new LinkedList[n];
		for(int[] edge : fares) {
			if(edges[edge[0] - 1] == null) edges[edge[0] - 1] = new LinkedList<>();
			if(edges[edge[1] - 1] == null) edges[edge[1] - 1] = new LinkedList<>();
			edges[edge[0] - 1].add(new int[]{edge[1] - 1, edge[2]});
			edges[edge[1] - 1].add(new int[]{edge[0] - 1, edge[2]});
		}

		return Math.min(recursion(s - 1, edges, target_1, visited) + recursion(s - 1, edges, target_2, visited), recursion(s - 1, edges, TOGETHER, visited));
	}
}
