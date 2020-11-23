package medium.Graph_Valid_Tree;

import org.junit.Test;

/**
 * need to retry and understand
 */
public class Solution {

	@Test
	public void execute() {
		int n = 3;
		int[][] edges = new int[][]{{0,1},{0,2},{1,2}};
		System.out.println(validTree(n, edges));
	}
	private int getParent(int cur, Integer[] parent) {
		while(parent[cur] != null) cur = parent[cur];
		return cur;
	}
	public boolean validTree(int n, int[][] edges) {
		if(n == 1) return true;
		if(n == 0 || edges == null || edges.length == 0) return false;
		Integer[] parent = new Integer[n];

		for(int[] edge : edges) {
			int p = getParent(edge[0], parent);
			int c = getParent(edge[1], parent);
			if(p == c) return false;
			parent[c] = p;
		}
		return edges.length == n-1;
	}
}
