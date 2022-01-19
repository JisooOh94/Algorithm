package 가장_먼_노드;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Time Complexity : O(V * E)
 * Subject : Dijkstra
 */
public class Solution {
	@Test
	public void execute() {
		int n = 6;
		int[][] edges = new int[][]{
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		System.out.println(solution(n, edges));
	}
	public int solution(int n, int[][] edge) {
		Integer[] minVals = new Integer[n];
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(val -> val[1]));
		List<Integer>[] edges = new LinkedList[n];
		for(int i = 0; i < n; i++) edges[i] = new LinkedList<>();
		for(int[] e : edge) {
			edges[e[0] - 1].add(e[1] - 1);
			edges[e[1] - 1].add(e[0] - 1);
		}
		minVals[0] = 0;
		queue.offer(new int[]{0, 0});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curIdx = cur[0];
			int curWeight = cur[1];
			for(int neighbor : edges[curIdx]) {
				if(minVals[neighbor] == null) {
					minVals[neighbor] = curWeight + 1;
					queue.offer(new int[]{neighbor, minVals[neighbor]});
				}
			}
		}
		int maxVal = 0;
		int maxCnt = 0;
		for(int val : minVals) {
			if(maxVal == val) maxCnt++;
			else if(maxVal < val) {
				maxVal = val;
				maxCnt = 1;
			}
		}
		return maxCnt;
	}
}
