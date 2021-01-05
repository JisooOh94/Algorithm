package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class Solution_2 {
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
	private static final int TIME = 1;

	public int networkDelayTime(int[][] times, int N, int K) {
		int delayTime = -1;
		int visitedNodeCnt = 0;

		boolean[] visited = new boolean[N + 1];
		List<int[]>[] neighborList = new LinkedList[N + 1];
		for (int[] edgeInfo : times) {
			if (neighborList[edgeInfo[0]] == null) neighborList[edgeInfo[0]] = new LinkedList<>();
			neighborList[edgeInfo[0]].add(new int[]{edgeInfo[1], edgeInfo[2]});
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{K, 1});

		while (!queue.isEmpty()) {
			if(visitedNodeCnt == N) break;
			int curNodeCnt = queue.size();

			for (int i = 0; i < curNodeCnt; i++) {
				int[] curNode = queue.poll();
				if(--curNode[TIME] == 0 && !visited[curNode[NODE]]) {
					visitedNodeCnt++;
					visited[curNode[NODE]] = true;
					if(neighborList[curNode[NODE]] != null) {
						for (int[] neighbor : neighborList[curNode[NODE]]) {
							if (!visited[neighbor[NODE]]) queue.offer(neighbor);
						}
					}
				} else if(!visited[curNode[NODE]]){
					queue.offer(curNode);
				}
			}
			delayTime++;
		}
		return visitedNodeCnt == N ? delayTime : -1;
	}
}



































