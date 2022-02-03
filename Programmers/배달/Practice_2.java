package 배달;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Practice_2 {
	@Test
	public void execute() {
		int n = 5; int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}; int k = 3;
//		int n = 6; int[][] road = new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{5,3,2},{3,5,3},{5,6,1}}; int k = 4;

		System.out.println(solution(n, road, k));
	}

	public int solution(int N, int[][] roads, int K) {
		List<int[]>[] edges = new LinkedList[N];
		for(int i = 0; i < N; i++) edges[i] = new LinkedList<>();
		for(int[] road : roads) {
			edges[road[0] - 1].add(new int[]{road[1] - 1, road[2]});
			edges[road[1] - 1].add(new int[]{road[0] - 1, road[2]});
		}

		Integer[] minDist = new Integer[N];
		minDist[0] = 0;

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(elem -> elem[1]));
		queue.add(new int[]{0,0});

		while(!queue.isEmpty()){
			int cur = queue.poll()[0];
			for(int[] neighbor : edges[cur]) {
				if(minDist[neighbor[0]] == null || minDist[neighbor[0]] > minDist[cur] + neighbor[1]) {
					minDist[neighbor[0]] = minDist[cur] + neighbor[1];
					queue.offer(new int[]{neighbor[0], minDist[neighbor[0]]});
				}
			}
		}

		int result = 0;
		for(int i : minDist) if(i <= K) result++;
		return result;
	}
}
