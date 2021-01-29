package medium.Minimum_Height_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 9ms(95.45%)
 * Memory : 40.3mb(97.36%)
 * Time Complexity : O(n)
 */
public class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n <= 2) return n == 1 ? Arrays.asList(0) : Arrays.asList(0,1);

		int[] neighborCnt = new int[n];
		List<Integer>[] edge = new LinkedList[n];
		Queue<Integer> leafQueue = new LinkedList<>();
		int leftNodeCnt = n;

		for(int[] e : edges) {
			if(edge[e[0]] == null) edge[e[0]] = new LinkedList<>();
			if(edge[e[1]] == null) edge[e[1]] = new LinkedList<>();
			edge[e[0]].add(e[1]);
			edge[e[1]].add(e[0]);

			neighborCnt[e[0]]++;
			neighborCnt[e[1]]++;
		}

		for(int i = 0; i < n; i++) {
			if(neighborCnt[i] == 1) {
				neighborCnt[i] = 0;
				leafQueue.offer(i);
			}
		}

		while(!leafQueue.isEmpty()) {
			if(leftNodeCnt <= 2) break;

			int loop = leafQueue.size();
			for(int i = 0; i < loop; i++) {

				int cur = leafQueue.poll();
				leftNodeCnt--;

				for (int neighbor : edge[cur]) {
					if (neighborCnt[neighbor] != 0) {
						if (--neighborCnt[neighbor] == 1) {
							leafQueue.offer(neighbor);
						}
					}
				}
			}
		}

		return new ArrayList<>(leafQueue);
	}
}
