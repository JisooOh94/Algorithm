package medium.Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Time Complexity : O(n^2)
 * Space Complexity : O(n^2)
 * Runtime : 24ms(41.59%)
 * Memory : 39.3mb(90.13%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 5;
		int[][] edges = new int[][]{
				{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}
		};
		int distanceThreshold = 2;

		System.out.println(findTheCity(n, edges, distanceThreshold));
	}
	private static final int NODE = 0;
	private static final int WEIGHT = 1;
	private int getMinIdx(boolean[] visited, Integer[] minDist) {
		int minVal = 9999999;
		int minIdx = -1;
		for(int i = 0; i < visited.length; i++) {
			if(minDist[i] != null && minDist[i] < minVal && !visited[i]) {
				minVal = minDist[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	private int dijkstra(int startPos, int nodeCnt, List<int[]>[] neighborList, int distThreshold) {
		boolean[] visited = new boolean[nodeCnt];
		Integer[] minDist = new Integer[nodeCnt];
		minDist[startPos] = 0;
		int visitedNodeCnt = 0;

		for(int i = 0; i < nodeCnt; i++) {
			int curIdx = getMinIdx(visited, minDist);
			if(curIdx == -1 || minDist[curIdx] > distThreshold) break;

			visited[curIdx] = true;
			visitedNodeCnt++;
			if(neighborList[curIdx] != null) {
				for (int[] neighbor : neighborList[curIdx]) {
					minDist[neighbor[NODE]] = minDist[neighbor[NODE]] == null ? minDist[curIdx] + neighbor[WEIGHT] : Math.min(minDist[neighbor[NODE]], minDist[curIdx] + neighbor[WEIGHT]);
				}
			}
		}

		return visitedNodeCnt;
	}

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		List<int[]>[] neighborList = new LinkedList[n];
		for(int[] edge : edges) {
			if(neighborList[edge[0]] == null) neighborList[edge[0]] = new LinkedList<>();
			if(neighborList[edge[1]] == null) neighborList[edge[1]] = new LinkedList<>();
			neighborList[edge[0]].add(new int[]{edge[1], edge[2]});
			neighborList[edge[1]].add(new int[]{edge[0], edge[2]});
		}

		int minReachableCnt = 999999;
		int minIdx = -1;
		for(int i = 0; i < n; i++) {
			int curReachableCnt = dijkstra(i, n, neighborList, distanceThreshold);
			if(curReachableCnt <= minReachableCnt) {
				minReachableCnt = curReachableCnt;
				minIdx = i;
			}
		}
		return minIdx;
	}
}
