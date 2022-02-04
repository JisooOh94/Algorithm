package 합승_택시_요금;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Time Complexity : O(n^2)
 * Subject : dijkstra
 */
public class Solution {
	@Test
	public void execute() {
//		int n = 6;int s = 4;int a = 6;int b = 2;int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		int n = 7;int s = 3;int a = 4;int b = 1;int[][] fares = new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
//		int n = 6;int s = 4;int a = 5;int b = 6;int[][] fares = new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};

		System.out.println(solution(n, s, a, b, fares));
	}
	private static final int FROM_S = 0;
	private static final int FROM_A = 1;
	private static final int FROM_B = 2;

	private static final int TO = 0;
	private static final int WEIGHT = 1;

	private void dijkstra(int from, int start, int n, List<int[]>[] edgegs, Integer[][] minWeight) {
		boolean[] visited = new boolean[n];
		minWeight[start][from] = 0;

		while(true) {
			Integer minIdx = null;
			for(int i = 0; i < n; i++) {
				if(!visited[i] && minWeight[i][from] != null && (minIdx == null || minWeight[i][from] < minWeight[minIdx][from])) minIdx = i;
			}

			if(minIdx == null) break;
			visited[minIdx] = true;
			for(int[] neighbor : edgegs[minIdx]) {
				if(minWeight[neighbor[TO]][from] == null || minWeight[minIdx][from] + neighbor[WEIGHT] < minWeight[neighbor[TO]][from]) minWeight[neighbor[TO]][from] = minWeight[minIdx][from] + neighbor[WEIGHT];
			}
		}
	}

	public int solution(int n, int s, int a, int b, int[][] fares) {
		s--; a--; b--;
		Integer[][] minWeight = new Integer[n][3];
		List<int[]>[] edges = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			minWeight[i] = new Integer[3];
			edges[i] = new LinkedList<>();
		}
		for(int[] fare : fares) {
			edges[fare[0] - 1].add(new int[]{fare[1] - 1, fare[2]});
			edges[fare[1] - 1].add(new int[]{fare[0] - 1, fare[2]});
		}



		dijkstra(FROM_S, s, n, edges, minWeight);
		dijkstra(FROM_A, a, n, edges, minWeight);
		dijkstra(FROM_B, b, n, edges, minWeight);

		int single = minWeight[a][FROM_S] + minWeight[b][FROM_S];
		Integer together = null;
		for(int i = 1; i < n; i++) {
			if(minWeight[i][FROM_S] == null) continue;
			together = together == null ? minWeight[i][FROM_S] + minWeight[i][FROM_A] + minWeight[i][FROM_B] : Math.min(together, minWeight[i][FROM_S] + minWeight[i][FROM_A] + minWeight[i][FROM_B]);
		}

		return Math.min(single, together);
	}
}
