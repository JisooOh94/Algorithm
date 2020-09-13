package Prob_4;

import java.util.*;

import org.junit.Test;

public class Solution {
	private static final int TOGETHER = 2;
	private static final int TARGET_A = 0;
	private static final int TARGET_B = 1;

	@Test
	public void execute() {
		int n = 6; int s = 4; int a = 6; int b = 2; int[][] fares = new int[][]{ {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25} };

		System.out.println(solution(n, s, a, b, fares));
	}

	private int recursion (int curPos, List<int[]>[] edges, int targetIdx, int[] target, boolean[] visited, Integer[][] record) {
		if(targetIdx != TOGETHER && curPos == target[targetIdx]) return 0;
		else if(record[curPos][targetIdx] != null) return record[curPos][targetIdx];

		int minCost = 99999;
		for(int[] edge : edges[curPos]) {
			if(!visited[edge[0]]) {
				int nextPos = edge[0];
				int curCost = edge[1];
				visited[nextPos] = true;

				if(targetIdx == TOGETHER) {
					curCost += Math.min(recursion(nextPos, edges, TARGET_A, target, visited, record)  + recursion(nextPos, edges, TARGET_B, target,  visited, record), recursion(nextPos, edges, TOGETHER, target, visited, record));
				} else {
					curCost += recursion(nextPos, edges, targetIdx, target, visited, record);
				}
				minCost = Math.min(minCost, curCost);
				visited[nextPos] = false;
			}
		}

		record[curPos][targetIdx] = minCost;

		return minCost;
	}

	public int solution(int n, int s, int a, int b, int[][] fares) {
		int[] target = new int[]{a - 1, b - 1};

		Integer[][] record = new Integer[n][3];
		boolean[] visited = new boolean[n];
		visited[s - 1] = true;
		List<int[]>[] edges = new LinkedList[n];
		for(int[] edge : fares) {
			if(edges[edge[0] - 1] == null) edges[edge[0] - 1] = new LinkedList<>();
			if(edges[edge[1] - 1] == null) edges[edge[1] - 1] = new LinkedList<>();
			edges[edge[0] - 1].add(new int[]{edge[1] - 1, edge[2]});
			edges[edge[1] - 1].add(new int[]{edge[0] - 1, edge[2]});
		}

		return Math.min(recursion(s - 1, edges, TARGET_A, target, visited, record) + recursion(s - 1, edges, TARGET_B, target, visited, record), recursion(s - 1, edges, TOGETHER, target, visited, record));
	}
}
