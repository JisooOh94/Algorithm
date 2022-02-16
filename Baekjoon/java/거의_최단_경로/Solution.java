package 거의_최단_경로;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

/**
 * Subject : dijkstra
 */
public class Solution {
	private static final int NODE = 0;
	private static final int WEIGHT = 1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int n = scanner.nextInt();
			int e = scanner.nextInt();
			if(n == 0 && e == 0) break;

			int s = scanner.nextInt();
			int t = scanner.nextInt();

			List<int[]>[] edges_all = new LinkedList[n];
			List<int[]>[] edges_left = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				edges_all[i] = new LinkedList<>();
				edges_left[i] = new LinkedList<>();
			}

			for (int i = 0; i < e; i++) edges_all[scanner.nextInt()].add(new int[]{scanner.nextInt(), scanner.nextInt()});

			Pair<Integer, List<Integer>>[] minCost_all = new Pair[n];
			minCost_all[s] = new Pair<>(0, Collections.emptyList());

			PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(idx -> minCost_all[idx].getKey()));
			queue.offer(s);

			while (!queue.isEmpty()) {
				int minIdx = queue.poll();
				if (minIdx == t) break;

				for (int[] neighbor : edges_all[minIdx]) {
					if (minCost_all[neighbor[NODE]] == null || minCost_all[minIdx].getKey() + neighbor[WEIGHT] < minCost_all[neighbor[NODE]].getKey()) {
						minCost_all[neighbor[NODE]] = new Pair<>(minCost_all[minIdx].getKey() + neighbor[WEIGHT], new LinkedList<>(Arrays.asList(minIdx)));
						queue.offer(neighbor[NODE]);
					} else if (minCost_all[minIdx].getKey() + neighbor[WEIGHT] == minCost_all[neighbor[NODE]].getKey()) {
						minCost_all[neighbor[NODE]].getValue().add(minIdx);
					}
				}
			}

			boolean[][] isMinPath = new boolean[n][n];
			boolean[] checked = new boolean[n];
			Queue<Integer> minPathNode = new LinkedList<>(Arrays.asList(t));
			checked[t] = true;
			while(!minPathNode.isEmpty()) {
				int to = minPathNode.poll();
				if(minCost_all[to] != null) {
					for (int from : minCost_all[to].getValue()) {
						isMinPath[from][to] = true;
						if (!checked[from]) {
							checked[from] = true;
							minPathNode.offer(from);
						}
					}
				}
			}

			for (int i = 0; i < n; i++)
				for (int[] neighbor : edges_all[i])
					if (!isMinPath[i][neighbor[NODE]]) edges_left[i].add(neighbor);

			Integer[] minCost_left = new Integer[n];
			minCost_left[s] = 0;
			queue = new PriorityQueue<>(Comparator.comparingInt(idx -> minCost_left[idx]));
			queue.offer(s);

			while (!queue.isEmpty()) {
				int minIdx = queue.poll();
				if (minIdx == t) break;

				for (int[] neighbor : edges_left[minIdx]) {
					if (minCost_left[neighbor[NODE]] == null || minCost_left[minIdx] + neighbor[WEIGHT] < minCost_left[neighbor[NODE]]) {
						minCost_left[neighbor[NODE]] = minCost_left[minIdx] + neighbor[WEIGHT];
						queue.offer(neighbor[NODE]);
					}
				}
			}

			System.out.println(minCost_left[t] == null ? -1 : minCost_left[t]);
		}
	}
}
