package 파티;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static void dijkstra(int dir, int start, int n, List<int[]>[] edges, Integer[][] minW) {
		boolean[] visited = new boolean[n];
		minW[start][dir] = 0;
		for(int loop = 0; loop < n; loop++) {
			Integer minIdx = null;
			for(int i = 0; i < n; i++) {
				if(!visited[i] && minW[i][dir] != null && (minIdx == null || minW[i][dir] < minW[minIdx][dir])) minIdx = i;
			}
			visited[minIdx] = true;
			for(int[] neighbor : edges[minIdx]) {
				if(minW[neighbor[0]][dir] == null || minW[minIdx][dir] + neighbor[1] < minW[neighbor[0]][dir]) minW[neighbor[0]][dir] = minW[minIdx][dir] + neighbor[1];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt() - 1;
		List<int[]>[] reversedEdges = new LinkedList[n];
		List<int[]>[] forwardedEdges = new LinkedList[n];

		for(int i = 0; i < n; i++) {
			reversedEdges[i] = new LinkedList<>();
			forwardedEdges[i] = new LinkedList<>();
		}

		for(int i = 0; i < m; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int weight = sc.nextInt();

			reversedEdges[to].add(new int[]{from, weight});
			forwardedEdges[from].add(new int[]{to, weight});
		}

		Integer[][] minW = new Integer[n][2];
		dijkstra(0, x, n, reversedEdges, minW);
		dijkstra(1, x, n, forwardedEdges, minW);

		int result = minW[0][0] + minW[0][1];
		for(int i = 1; i < n; i++) result = Math.max(result, minW[i][0] + minW[i][1]);
		System.out.println(result);
	}
}
