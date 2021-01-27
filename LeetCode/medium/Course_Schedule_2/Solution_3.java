package medium.Course_Schedule_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import util.Predicate;

/**
 * Runtime : 4ms(80.14%)
 * Memory : 39.6mb(94.35%)
 */
public class Solution_3 implements Predicate<int[], Object> {
	public int[] test(Object... params) {
		int[] result = findOrder((int)params[0], (int[][])params[1]);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		return null;
	}

	private static final int[] EMPTY_ARR = new int[0];

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] edgeList = new LinkedList[numCourses];
		int[] preCondition = new int[numCourses];

		for(int[] edge : prerequisites) {
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[1]].add(edge[0]);
			preCondition[edge[0]]++;
		}

		int[] order = new int[numCourses];
		int orderIdx = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < numCourses; i++) {
			if(preCondition[i] == 0) {
				queue.offer(i);
			}
		}

		while(!queue.isEmpty()) {
			int cur = queue.poll();
			order[orderIdx++] = cur;

			if(edgeList[cur] != null) {
				for (int child : edgeList[cur]) {
					if (--preCondition[child] == 0) {
						queue.offer(child);
					}
				}
			}
		}

		return orderIdx < numCourses ? EMPTY_ARR : order;
	}
}
