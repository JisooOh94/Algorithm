package medium.Tree_Diameter;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 13ms(51.41%)
 * Memory : 39.5mb(7.96%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] edges = new int[][]{
				{0, 1},
				{0,2}
		};
		System.out.println(treeDiameter(edges));
	}
	private int recursion (int curNode, int from, List<Integer>[] edges, List<Integer>[] record) {
		int max = 0;
		for(int i = 0; i < edges[curNode].size(); i++) {
			int next = edges[curNode].get(i);
			if(next == from) continue;
			if(record[curNode].get(i) != -1) max = Math.max(max, record[curNode].get(i));
			else {
				int pahtLength = 1 + recursion(next, curNode, edges, record);
				record[curNode].set(i, pahtLength);
				max = Math.max(max,pahtLength);
			}
		}

		return max;
	}
	public int treeDiameter(int[][] edges) {
		if(edges.length == 0) return 0;
		List<Integer>[] edgeList = new LinkedList[edges.length + 1];
		List<Integer>[] record = new LinkedList[edges.length + 1];
		for(int[] edge : edges) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			if(record[edge[0]] == null) record[edge[0]] = new LinkedList<>();
			if(record[edge[1]] == null) record[edge[1]] = new LinkedList<>();

			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
			record[edge[0]].add(-1);
			record[edge[1]].add(-1);
		}

		int max = 0;
		for(int i = 0; i < edges.length; i++) {
			max = Math.max(max, recursion(i, -1, edgeList, record));
		}
		return max;
	}
}
