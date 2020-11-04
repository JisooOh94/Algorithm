package medium.Connecting_Cities_With_Minimum_Cost;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
//		int n = 3; int[][] connections = new int[][]{{1,2,5},{1,3,6},{2,3,1}};
//		int[][] connections = new int[][]{{1,2,3},{3,4,4}};
		int n = 7; int[][] connections = new int[][]{{2,1,87129},{3,1,14707},{4,2,34505},{5,1,71766},{6,5,2615},{7,2,37352}};
		System.out.println(minimumCost(n, connections));
	}
	private int getParent(int cur, Integer[] parent) {
		while(parent[cur] != null) cur = parent[cur];
		return cur;
	}

	public int minimumCost(int N, int[][] connections) {
		Arrays.sort(connections, (e1, e2) -> e1[2] > e2[2] ? 1 : e1[2] < e2[2] ? -1 : 0);

		Integer[] parent = new Integer[N + 1];
		int totalCost = 0;
		int connected = N;
		for(int[] connection : connections) {
			int parentIdx = getParent(connection[0], parent);
			int childIdx = getParent(connection[1], parent);

			if(parentIdx == childIdx) continue;
			parent[childIdx] = parentIdx;
			totalCost += connection[2];
			if (--connected == 1) return totalCost;
		}
		return -1;
	}
}
