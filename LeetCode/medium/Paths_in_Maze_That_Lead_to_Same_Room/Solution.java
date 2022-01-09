package medium.Paths_in_Maze_That_Lead_to_Same_Room;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * TOL(DFS)
 * Subject : Graph
 */
public class Solution {
	@Test
	public void execute() {
//		int n = 5; int[][] edges = new int[][]{{1,2},{5,2},{4,1},{2,4},{3,1},{3,4}};
		int n = 4; int[][] edges = new int[][]{{1,2},{3,4}};
		System.out.println(numberOfPaths(n, edges));
	}
	private void recursion(int cur, int[] prev, Set<String> cycles, boolean[] visited, List<Integer>[] edges) {
		if(visited[cur]) {
			if(cur == prev[2]) {
				Arrays.sort(prev);
				cycles.add(Arrays.toString(prev));
			}
			return;
		}
		visited[cur] = true;
		for(int node : edges[cur]) {
			recursion(node, new int[]{cur, prev[0], prev[1]}, cycles, visited, edges);
		}
		visited[cur] = false;
	}

	public int numberOfPaths(int n, int[][] corridors) {
		int[] arr = new int[4];
		List<Integer>[] edges = new LinkedList[n];
		for(int i = 0; i < n; i++) edges[i] = new LinkedList<>();
		for(int[] edge : corridors) {
			edges[edge[0] - 1].add(edge[1] - 1);
			edges[edge[1] - 1].add(edge[0] - 1);
		}
		Set<String> cycles = new HashSet<>();
		boolean[] visited = new boolean[n];

		for(int i = 0; i < n; i++) recursion(i, new int[]{-1, -1, -1}, cycles, visited, edges);
		return cycles.size();
	}
}
