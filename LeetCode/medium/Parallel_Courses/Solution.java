package medium.Parallel_Courses;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 22ms(21.82%)
 * Memory : 52.4mb(21.45%)
 * Time Complexity : O(v * e)
 * Subject : topological sort, graph
 */
public class Solution {
	@Test
	public void execute() {
		int n = 1;
		int[][] relations = new int[][]{

		};
		System.out.println(minimumSemesters(n, relations));
	}
	public int minimumSemesters(int n, int[][] relations) {
		int[] inEdgeCnt = new int[n];
		List<Integer>[] edges = new LinkedList[n];
		for(int i = 0; i < n; i++) edges[i] = new LinkedList<>();

		for(int[] relation : relations) {
			inEdgeCnt[relation[1] - 1]++;
			edges[relation[0] - 1].add(relation[1] - 1);
		}

		int visitCnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(inEdgeCnt[i] == 0) {
				queue.offer(i);
				visitCnt++;
			}
		}

		int loopCnt = 0;
		while(!queue.isEmpty()) {
			loopCnt++;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int cur = queue.poll();
				for(int neighbor : edges[cur]) {
					if(--inEdgeCnt[neighbor] == 0) {
						queue.offer(neighbor);
						visitCnt++;
					}
				}
			}
		}

		return visitCnt == n ? loopCnt : -1;
	}
}
