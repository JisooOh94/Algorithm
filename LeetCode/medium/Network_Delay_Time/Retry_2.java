package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Retry_2 {
	@Test
	public void execute() {
		int[][] times = new int[][]{
				{2,1,1},
				{2,3,1},
				{3,4,1}
		};
		int n = 4;
		int k = 2;
		System.out.println(networkDelayTime(times, n, k));
	}
	private int getMinIdx(Integer[] cost, boolean[] visited) {
		int minVal = 99999;
		int minIdx = -1;
		for(int i = 1; i < cost.length; i++) {
			if(cost[i] != null && !visited[i] && cost[i] < minVal) {
				minIdx = i;
				minVal = cost[i];
			}
		}
		return minIdx;
	}
	public int networkDelayTime(int[][] times, int nodeCnt, int startPos) {
		Integer[] cost = new Integer[nodeCnt + 1];
		boolean[] visited = new boolean[nodeCnt + 1];

		List<int[]>[] edges = new LinkedList[nodeCnt + 1];
		for(int[] time : times) {
			if(edges[time[0]] == null) edges[time[0]] = new LinkedList<>();
			edges[time[0]].add(new int[]{time[1], time[2]});
		}

		int maxCost = 0;
		int totalVisited = 0;

		cost[startPos] = 0;
		while(totalVisited < nodeCnt) {
			int minIdx = getMinIdx(cost, visited);
			if(minIdx == -1) return -1;
			visited[minIdx] = true;
			totalVisited++;
			maxCost = Math.max(maxCost, cost[minIdx]);

			if(edges[minIdx] != null) {
				for (int[] edge : edges[minIdx]) {
					cost[edge[0]] = cost[edge[0]] == null ? cost[minIdx] + edge[1] : Math.min(cost[edge[0]], cost[minIdx] + edge[1]);
				}
			}
		}
		return maxCost;
	}
}
