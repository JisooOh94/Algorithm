package 인간_대포;

import java.util.Scanner;

/**
 * Subject : dijkstra
 */
public class Main {
	private static final double WALK_SPEED = 5.0;
	private static final double CANON_COST = 2.0;
	private static final double CANON_RANGE = 50.0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] from = new double[]{sc.nextDouble(), sc.nextDouble()};
		double[] to = new double[]{sc.nextDouble(), sc.nextDouble()};

		int n = sc.nextInt() + 2;

		double[][] nodes = new double[n][n];
		nodes[0] = from;
		nodes[n - 1] = to;

		for(int i = 1; i < n - 1; i++) {
			nodes[i] = new double[]{sc.nextDouble(), sc.nextDouble()};
		}

		double[] minCost = new double[n];
		minCost[0] = 0;

		boolean[] visited = new boolean[n];
		visited[0] = true;

		for(int i = 1; i < n; i++) {
			double dist = getDist(nodes[0], nodes[i]);
			minCost[i] = dist / WALK_SPEED;
		}

		while (true) {
			Integer minIdx = null;
			for(int i = 1; i < n; i++) {
				if(!visited[i] && (minIdx == null || minCost[i] < minCost[minIdx])) minIdx = i;
			}

			if(minIdx == null) break;
			if(minIdx == n - 1) break;

			visited[minIdx] = true;

			for(int i = 0; i < n; i++) {
				if(i == minIdx) continue;
				if(minCost[minIdx] + getCost(nodes[minIdx], nodes[i]) < minCost[i]) {
					minCost[i] = minCost[minIdx] + getCost(nodes[minIdx], nodes[i]);
				}
			}
		}

		System.out.println(minCost[n - 1]);
	}

	private static double getCost(double[] from, double[] to) {
		double dist = Math.abs(getDist(from, to) - CANON_RANGE);
		return CANON_COST + dist / WALK_SPEED;
	}

	private static double getDist(double[] from, double[] to) {
		return Math.sqrt(Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2));
	}
}
