package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 7ms(94.97%)
 * Memory : 42.8mb(58.15%)
 */
public class Solution_4 {
	@Test
	public void execute() {
		int[][] times = new int[][]{
				{1, 2, 1},
				{2, 3, 2},
				{1, 3, 4},
		};
		int N = 3;
		int K = 1;
		System.out.println(networkDelayTime(times, N, K));
	}

	private static final int NODE = 0;
	private static final int LEN = 1;

	private int getidx(boolean[] visited, Integer[] shortestPath) {
		int min = 999999;
		int minIdx = -1;
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i] && shortestPath[i] != null && shortestPath[i] < min) {
				min = shortestPath[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	public int networkDelayTime(int[][] times, int nodeCnt, int startPos) {
		int longestPath = 0;
		int visitedCnt = 0;

		boolean[] visited = new boolean[nodeCnt + 1];
		Integer[] shortestPath = new Integer[nodeCnt + 1];
		List<int[]>[] neighborList = new LinkedList[nodeCnt + 1];
		for (int[] edgeInfo : times) {
			if (neighborList[edgeInfo[0]] == null) neighborList[edgeInfo[0]] = new LinkedList<>();
			neighborList[edgeInfo[0]].add(new int[]{edgeInfo[1], edgeInfo[2]});
		}

		shortestPath[startPos] = 0;

		for(int i = 0; i < nodeCnt; i++) {
			int cur = getidx(visited, shortestPath);
			if(cur == -1) break;

			visited[cur] = true;
			visitedCnt++;
			longestPath = Math.max(longestPath, shortestPath[cur]);

			if(neighborList[cur] != null) {
				for (int[] neighbor : neighborList[cur]) {
					if (!visited[neighbor[NODE]]) {
						int curShortPath = shortestPath[neighbor[NODE]] == null ? shortestPath[cur] + neighbor[LEN] : Math.min(shortestPath[neighbor[NODE]], shortestPath[cur] + neighbor[LEN]);
						shortestPath[neighbor[NODE]] = curShortPath;
					}
				}
			}
		}

		return visitedCnt == nodeCnt ? longestPath : -1;
	}
}
