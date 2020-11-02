package medium.Redundant_Connection;

import java.util.Arrays;

/**
 * Runtime : 1ms(62.47%)
 * Memory : 39.5mb(13.66%)
 */
public class Solution {
	private int getParent(int cur, Integer[] parent) {
		while(parent[cur] != null) cur = parent[cur];
		return cur;
	}
	public int[] findRedundantConnection(int[][] edges) {
		Integer[] parent = new Integer[edges.length + 1];
		for(int[] edge : edges) {
			Arrays.sort(edge);
			int parentIdx = getParent(edge[0], parent);
			int childIdx = getParent(edge[1], parent);

			if(parentIdx == childIdx) return edge;
			else {
				parent[childIdx] = parentIdx;
			}
		}
		return null;
	}
}
