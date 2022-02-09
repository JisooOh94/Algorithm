package 녹색_옷_입은_애가_젤다지;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Subject ; dijkstra
 */
public class Solution {
	private static final int Y = 0;
	private static final int X = 1;
	private static final int W = 2;
	private static final int[][] dirs = new int[][]{
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};

	private static boolean isInRange(int y, int x, int n) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}

	private static int getMinWeight(int[][] weight, int n) {
		boolean[][] visited = new boolean[n][n];
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(val -> val[W]));
		queue.offer(new int[]{0, 0, weight[0][0]});
		Integer[][] minW = new Integer[n][n];
		minW[0][0] = weight[0][0];

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[Y] == n - 1 && cur[X] == n - 1) {
				break;
			}

			visited[cur[Y]][cur[X]] = true;
			for(int[] dir : dirs) {
				int neY = cur[Y] + dir[Y];
				int neX = cur[X] + dir[X];
				if(isInRange(neY, neX, n) && (minW[neY][neX] == null || minW[cur[Y]][cur[X]] + weight[neY][neX] < minW[neY][neX])) {
					 minW[neY][neX] = minW[cur[Y]][cur[X]] + weight[neY][neX];
					 queue.offer(new int[]{neY, neX, minW[neY][neX]});
				}
			}
		}

		return minW[n - 1][n - 1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		int idx = 1;
		while(n != 0) {
			int[][] weight = new int[n][n];
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					weight[y][x] = sc.nextInt();
				}
			}
			int result = getMinWeight(weight, n);
			System.out.println("Problem " + idx + ": " + result);
			n = sc.nextInt();
			idx++;
		}
	}
}
