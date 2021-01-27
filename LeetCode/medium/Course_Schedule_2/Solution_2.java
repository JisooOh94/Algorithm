package medium.Course_Schedule_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import util.Predicate;

/**
 * Runtime : 13ms(20/83%)
 * Memory : 39.9mb(78.51%%)
 */
public class Solution_2 implements Predicate<int[], Object> {
	public int[] test(Object... params) {
		int[] result = findOrder((int)params[0], (int[][])params[1]);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		return null;
	}

	private static final int[] EMPTY_ARR = new int[0];

	private boolean recursion(int cur, long parent, boolean[] localVisited, boolean[] globalVisited, List<Integer>[] edgeList, long[][] order) {
		if(order[cur][1] <= parent) order[cur][1] = parent + 1;
		globalVisited[cur] = true;
		localVisited[cur] = true;
		if(edgeList[cur] != null) {
			for(int edge : edgeList[cur]) {
				if(localVisited[edge] || !recursion(edge, order[cur][1], localVisited, globalVisited, edgeList, order)) return false;
			}
		}
		localVisited[cur] = false;
		return true;
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		long[][] order = new long[numCourses][2];
		for(int i = 0; i < numCourses; i++) {
			order[i] = new long[2];
			order[i][0] = i;
		}

		List<Integer>[] edgeList = new LinkedList[numCourses];
		for(int[] pre : prerequisites) {
			if(edgeList[pre[1]] == null) edgeList[pre[1]] = new LinkedList<>();
			edgeList[pre[1]].add(pre[0]);
		}
		boolean[] globalVisited = new boolean[numCourses];
		for(int i = 0; i < numCourses; i++) {
			if(!globalVisited[i]) {
				if(!recursion(i, order[i][1], new boolean[numCourses], globalVisited, edgeList, order)) return EMPTY_ARR;
			}
		}
		Arrays.sort(order, (e1, e2) -> e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : 0);
		return Stream.of(order).flatMapToInt(e -> IntStream.of((int)e[0])).toArray();
	}
}
