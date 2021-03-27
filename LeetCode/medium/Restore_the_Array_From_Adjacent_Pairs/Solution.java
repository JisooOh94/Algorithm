package medium.Restore_the_Array_From_Adjacent_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Runtime : 123ms(86.16%)
 * Memory : 95.1mb(66.14%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[][] adjacent = new int[][]{{2,1},{3,4},{3,2}};
		System.out.println(restoreArray(adjacent));
	}
	private static final int FRONT = 0;
	private static final int REAR = 1;
	private void recursion(int cur, int from, int dir, Map<Integer, List<Integer>> record, LinkedList<Integer> recoverList) {
		if (dir == FRONT) recoverList.addFirst(cur);
		else recoverList.addLast(cur);

		List<Integer> neighbor = record.get(cur);
		if(neighbor.size() > 1) {
			int next = neighbor.get(0) == from ? neighbor.get(1) : neighbor.get(0);
			recursion(next, cur, dir, record, recoverList);
		}
	}
	public int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> record = new HashMap<>();
		for(int[] pair : adjacentPairs) {
			List<Integer> neighbor_0 = record.getOrDefault(pair[0], new ArrayList<>(2));
			List<Integer> neighbor_1 = record.getOrDefault(pair[1], new ArrayList<>(2));
			neighbor_0.add(pair[1]);
			neighbor_1.add(pair[0]);
			record.putIfAbsent(pair[0], neighbor_0);
			record.putIfAbsent(pair[1], neighbor_1);
		}

		int start = adjacentPairs[0][0];
		List<Integer> neighbor = record.get(start);
		LinkedList<Integer> recoverList = new LinkedList<>(Arrays.asList(start));

		recursion(neighbor.get(FRONT), start, FRONT, record, recoverList);
		if(neighbor.size() > 1) recursion(neighbor.get(REAR), start, REAR, record, recoverList);
		return recoverList.stream().mapToInt(i -> i).toArray();
	}
}