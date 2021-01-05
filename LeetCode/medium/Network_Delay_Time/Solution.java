package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[][] times = new int[][]{
				{1, 2, 1},
				{2, 3, 7},
				{1, 3, 4},
				{2,1,2}
		};
		int N = 3;
		int K = 2;
		System.out.println(networkDelayTime(times, N, K));
	}

	private static final int NODE = 0;
	private static final int TIME = 1;

	public int networkDelayTime(int[][] times, int N, int K) {
		int totalTime = 0;
		int totalVisitedNode = 0;
		Integer[] visited = new Integer[N + 1];

		List<int[]>[] edgeList = new LinkedList[N + 1];
		for (int[] edgeInfo : times) {
			if (edgeList[edgeInfo[0]] == null) edgeList[edgeInfo[0]] = new LinkedList<>();
			edgeList[edgeInfo[0]].add(new int[]{edgeInfo[1], edgeInfo[2]});
		}

		Queue<Integer> queue = new LinkedList<>();
		visited[K] = 1;
		queue.offer(K);

		while (!queue.isEmpty()) {
			int size = queue.size();

			List<Integer> updated = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if(!updated.contains(cur)) {
					if (--visited[cur] == 0) {
						totalVisitedNode++;
						if(edgeList[cur] != null) {
							for (int[] neighbor : edgeList[cur]) {
								if (visited[neighbor[NODE]] == null) {
									queue.offer(neighbor[NODE]);
									visited[neighbor[NODE]] = neighbor[TIME];
								} else if (neighbor[TIME] < visited[neighbor[NODE]]) {
									visited[neighbor[NODE]] = neighbor[TIME];
									updated.add(neighbor[NODE]);
								}
							}
						}
					} else {
						queue.offer(cur);
					}
				} else {
					queue.offer(cur);
				}
			}
			totalTime++;
		}

		return totalVisitedNode == N ? totalTime - 1 : -1;
	}
}



































