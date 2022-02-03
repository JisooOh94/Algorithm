package 배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Subject : dijkstra
 */
public class Practice {
	@Test
	public void execute() {
		int n = 5; int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}; int k = 3;
//		int n = 6; int[][] road = new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{5,3,2},{3,5,3},{5,6,1}}; int k = 4;

		System.out.println(solution(n, road, k));
	}
	public int solution(int N, int[][] roads, int K) {
		Integer[] minDist = new Integer[N];
		boolean[] visited = new boolean[N];
		List<int[]>[] edges = new LinkedList[N];
		for(int i = 0; i < N; i++) edges[i] = new LinkedList<>();
		for(int[] road : roads) {
			edges[road[0] - 1].add(new int[]{road[1] - 1, road[2]});
			edges[road[1] - 1].add(new int[]{road[0] - 1, road[2]});
		}

		minDist[0] = 0;

		for(int loop = 0; loop < N; loop++) {
			int minIdx = 0;
			int minVal = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				if(!visited[i] && minDist[i] != null && minDist[i] < minVal) {
					minIdx = i;
					minVal = minDist[i];
				}
			}
			visited[minIdx] = true;
			for(int[] neighbor : edges[minIdx]) {
				if(minDist[neighbor[0]] == null || minDist[neighbor[0]] > minDist[minIdx] + neighbor[1])
					minDist[neighbor[0]] = minDist[minIdx] + neighbor[1];
			}
		}

		int result = 0;
		for(int i = 0; i < N; i++) {
			if (minDist[i] <= K) result++;
		}
		return result;
	}
}
