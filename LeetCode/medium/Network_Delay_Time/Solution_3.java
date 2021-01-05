package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Solution_3 {
	@Test
	public void execute() {
		int[][] times = new int[][]{
				{1, 2, 1},
				{2, 3, 7},
				{1, 3, 4},
				{2, 1, 2}
		};
		int N = 4;
		int K = 1;
		System.out.println(networkDelayTime(times, N, K));
	}

	private static final int NODE = 0;
	private static final int LEN = 1;
	public int networkDelayTime(int[][] times, int nodeCnt, int startPos) {
		boolean[] visited = new boolean[nodeCnt + 1];
		Integer[] shortestPath = new Integer[nodeCnt + 1];
		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[LEN] > e2[LEN] ?  1 : e1[LEN] < e2[LEN] ?  -1 : 0);
		List<int[]>[] neighborList = new LinkedList[nodeCnt + 1];
		for (int[] edgeInfo : times) {
			if (neighborList[edgeInfo[0]] == null) neighborList[edgeInfo[0]] = new LinkedList<>();
			neighborList[edgeInfo[0]].add(new int[]{edgeInfo[1], edgeInfo[2]});
		}

		shortestPath[startPos] = 0;
		queue.offer(new int[]{startPos, 0});
		int longestPath = 0;
		int visitedCnt = 0;

		for(int i = 0; i < nodeCnt; i++) {
			int[] cur = null;
			do {
				if(queue.isEmpty()) break;
				cur = queue.poll();
			} while(visited[cur[NODE]]);

			visited[cur[NODE]] = true;
			visitedCnt++;
			if(neighborList[cur[NODE]] != null) {
				for (int[] neighbor : neighborList[cur[NODE]]) {
					if (!visited[neighbor[NODE]]) {
						int curShortPath = shortestPath[neighbor[NODE]] == null ? cur[LEN] + neighbor[LEN] : Math.min(shortestPath[neighbor[NODE]], cur[LEN] + neighbor[LEN]);
						shortestPath[neighbor[NODE]] = curShortPath;
						queue.offer(new int[]{neighbor[NODE], curShortPath});
						longestPath = Math.max(longestPath, curShortPath);
					}
				}
			}
		}

		return visitedCnt == nodeCnt ? longestPath : -1;
	}
}
