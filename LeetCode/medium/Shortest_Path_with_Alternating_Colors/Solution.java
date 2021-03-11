package medium.Shortest_Path_with_Alternating_Colors;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 3ms(99.82%)
 * Memory : 39.6mb(73.95%)
 * Time Complexity : O(E)
 */
public class Solution {
	private static final int POS = 0;
	private static final int COLOR = 1;
	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		List<Integer>[][] neighbors = new LinkedList[n][2];

		boolean[][] visited = new boolean[n][2];
		int[] minCost = new int[n];
		Queue<int[]> queue = new LinkedList<>();

		for(int[] edge : red_edges) {
			if(neighbors[edge[0]][0] == null) neighbors[edge[0]][0] = new LinkedList<>();
			neighbors[edge[0]][0].add(edge[1]);
		}
		for(int[] edge : blue_edges) {
			if(neighbors[edge[0]][1] == null) neighbors[edge[0]][1] = new LinkedList<>();
			neighbors[edge[0]][1].add(edge[1]);
		}

		queue.offer(new int[]{0, 0});
		queue.offer(new int[]{0, 1});
		visited[0][0] = visited[0][1] = true;
		minCost[0] = 0;
		int cost = 0;

		while(!queue.isEmpty()) {
			cost++;
			int curCount = queue.size();

			for(int loop = 0; loop < curCount; loop++) {
				int[] cur = queue.poll();
				int nextColor = (cur[COLOR] + 1) % 2;
				if(neighbors[cur[POS]][nextColor] != null) {
					for (int neighbor : neighbors[cur[POS]][nextColor]) {
						if (!visited[neighbor][nextColor]) {
							if (minCost[neighbor] == 0) minCost[neighbor] = cost;
							visited[neighbor][nextColor] = true;
							queue.offer(new int[]{neighbor, nextColor});
						}
					}
				}
			}
		}

		for(int i = 1; i < n; i++) if(minCost[i] == 0) minCost[i] = -1;
		return minCost;
	}
}
