package medium.Course_Schedule_IV;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 41ms(81.82%)
 * Memory : 90.1mb(17.13%)
 * Time Complexity : O(V + E^2)
 * Subject : graph, BFS
 */
public class Solution {
	@Test
	public void execute() {
		int numCourses = 3;
		int[][] prerequisites = new int[][]{
				{1,2}, {1,0}, {2,0}
		};
		int[][] queries = new int[][]{
				{1,0}, {1,2}
		};

		checkIfPrerequisite(numCourses, prerequisites, queries).stream().forEach(System.out::println);
	}
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		List<Integer>[] edges = new LinkedList[numCourses];
		for(int i = 0; i < numCourses; i++) edges[i] = new LinkedList<>();

		for(int[] edge : prerequisites) {
			edges[edge[0]].add(edge[1]);
		}

		boolean[][] reachable = new boolean[numCourses][numCourses];
		for(int i = 0; i < numCourses; i++) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);

			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int neighbor : edges[cur]) {
					if(!reachable[i][neighbor]) {
						reachable[i][neighbor] = true;
						queue.offer(neighbor);
					}
				}
			}
		}

		List<Boolean> result = new LinkedList<>();
		for(int[] query : queries) {
			result.add(reachable[query[0]][query[1]]);
		}
		return result;
	}
}
