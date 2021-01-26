package medium.Course_Schedule;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 2ms(99.41%)
 * Memory : 39.9mb(49.84%)
 */
public class Solution {
	@Test
	public void execute() {
//		int num = 3; int[][] arr = new int[][]{{0,1},{0,2},{1,2}};
		int num = 2; int[][] arr = new int[][]{{0, 1}};
		System.out.println(canFinish(num, arr));
	}

	private boolean recursion(int cur, List<Integer>[] edgeList, boolean[] visited, boolean[] visited_2) {
		visited[cur] = true;
		visited_2[cur] = true;
		if(edgeList[cur] != null) {
			for (int neighbor : edgeList[cur]) {
				if(visited_2[neighbor]) return false;
				if(!visited[neighbor]) {
					if(!recursion(neighbor, edgeList, visited, visited_2)) return false;

				}
			}
		}
		visited_2[cur] = false;
		return true;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] edgeList = new LinkedList[numCourses];

		for(int[] edge : prerequisites) {
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[1]].add(edge[0]);
		}

		boolean[] visited = new boolean[numCourses];
		for(int i = 0; i < numCourses; i++) {
			if(!visited[i]) {
				if(!recursion(i, edgeList, visited, new boolean[numCourses])) return false;
			}
		}
		return true;
	}
}
