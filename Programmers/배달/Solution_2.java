package 배달;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Subject : dijkstra
 */
public class Solution_2 {
	@Test
	public void execute() {
		int n = 5; int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}; int k = 3;
//		int n = 6; int[][] road = new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{5,3,2},{3,5,3},{5,6,1}}; int k = 4;

		System.out.println(solution(n, road, k));
	}
	public int solution(int N, int[][] road, int K) {
		for(int[] r : road) {
			int r1 = r[0];
			int r2 = r[1];
			r[0] = Math.min(r1, r2);
			r[1] = Math.max(r1, r2);
		}

		Arrays.sort(road, (e1, e2) -> e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : e1[2] < e2[2] ? -1 : 1);
		List<int[]>[] edges = new LinkedList[N];
		for(int i = 0; i < N; i++) edges[i] = new LinkedList<>();
		int[] prev = null;
		for(int[] edge: road) {
			if(prev != null && prev[0] == edge[0] && prev[1] == edge[1]) continue;
			edges[edge[0] - 1].add(new int[]{edge[1] - 1, edge[2]});
			edges[edge[1] - 1].add(new int[]{edge[0] - 1, edge[2]});
			prev = edge;
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(val -> val[1]));
		Integer[] minVal = new Integer[N];

		minVal[0] = 0;
		queue.offer(new int[]{0, 0});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curIdx = cur[0];
			int curVal = cur[1];

			for(int[] neighbor : edges[curIdx]) {
				if(minVal[neighbor[0]] == null || curVal + neighbor[1] < minVal[neighbor[0]]) {
					minVal[neighbor[0]] = curVal + neighbor[1];
					queue.offer(new int[]{neighbor[0], minVal[neighbor[0]]});
				}
			}
		}
		int visitCnt = 0;
		for(int min : minVal) if(min <= K) visitCnt++;
		return visitCnt;
	}
}
