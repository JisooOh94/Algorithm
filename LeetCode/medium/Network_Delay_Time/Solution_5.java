package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 7ms(94.97%)
 * Memory : 42.8mb(58.15%)
 */
public class Solution_5 {
	@Test
	public void execute() {
		int[][] times = new int[][]{
				{2, 1, 1},
				{2, 3, 1},
				{3, 4, 1},
		};
		int N = 4;
		int K = 2;
		System.out.println(networkDelayTime(times, N, K));
	}

	private int getMinIdx(Integer[] minDist, boolean[] visited) {
		int min = 99999;
		int minIdx = -1;

		for(int i = 0; i < minDist.length; i++) {
			if(minDist[i] != null && minDist[i] < min && !visited[i]) {
				min = minDist[i];
				minIdx = i;
			}
		}

		return minIdx;
	}

	public int networkDelayTime(int[][] times, int nodeCnt, int startPos) {
		List<int[]>[] neighborList = new LinkedList[nodeCnt + 1];
		boolean[] visited = new boolean[nodeCnt + 1];
		Integer[] minDist = new Integer[nodeCnt + 1];

		for(int[] distInfo : times) {
			if(neighborList[distInfo[0]] == null) neighborList[distInfo[0]] = new LinkedList<>();
			neighborList[distInfo[0]].add(new int[]{distInfo[1], distInfo[2]});
		}

		int visitedNodeCnt = 0;
		int maxDist = 0;
		minDist[startPos] = 0;
		for(int i = 0; i < nodeCnt; i++) {
			int cur = getMinIdx(minDist, visited);
			if(cur == -1) break;
			visited[cur] = true;
			maxDist = Math.max(maxDist, minDist[cur]);
			visitedNodeCnt++;

			if(neighborList[cur] != null) {
				for (int[] neighbor : neighborList[cur]) {
					minDist[neighbor[0]] = minDist[neighbor[0]] == null ? minDist[cur] + neighbor[1] : Math.min(minDist[cur] + neighbor[1], minDist[neighbor[0]]);
				}
			}
		}
		return visitedNodeCnt == nodeCnt ? maxDist : -1;
	}
}
