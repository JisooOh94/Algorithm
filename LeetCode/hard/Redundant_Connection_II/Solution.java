package hard.Redundant_Connection_II;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.1mb(8.28%%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] edges = new int[][]{{2,1},{3,1},{4,2},{1,4}};
//		int[][] edges = new int[][]{{1,2}, {1,3}, {2,3}};
//		int[][] edges = new int[][]{{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
		int[][] edges = new int[][]{{3,4},{4,1},{1,2},{2,3},{5,1}};
		for(int num : findRedundantDirectedConnection(edges)) System.out.print(num + " ");
	}
	private int getParent(int cur, Integer[] parent) {
		while(parent[cur] != null && cur != parent[cur]) cur = parent[cur];
		return cur;
	}
	public int[] findRedundantDirectedConnection(int[][] edges) {
		Integer[] parent = new Integer[edges.length + 1];
		int[] duplicatedInfo = null;
		int[] invalid = null;
		for(int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int parentIdx = getParent(edge[0], parent);
			int childIdx = getParent(edge[1], parent);

			if(parent[edge[1]] != null) {
				duplicatedInfo = edge;
				int p = getParent(edge[1], parent);
				if(i == edges.length - 1 && parent[p] != null) {
					for (int[] edge_ : edges) if (edge_[1] == duplicatedInfo[1]) return edge_;
				}
			} else {
				if(parentIdx == childIdx) {
					if(duplicatedInfo != null) {
						for (int[] edge_ : edges) if (edge_[1] == duplicatedInfo[1]) return edge_;
					} else {
						invalid = edge;
					}
				}
				parent[childIdx] = parentIdx;
			}
		}
		return duplicatedInfo != null ? duplicatedInfo : invalid;
	}
}

