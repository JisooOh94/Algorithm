package medium.Maximal_Network_Rank;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 22ms(49.82%)
 * Memory : 40.2mb(46.95%)
 */
public class Solution {
	public int maximalNetworkRank(int n, int[][] roads) {
		if(roads == null || roads.length == 0) return 0;
		List<Integer>[] edgeList = new LinkedList[n];
		for(int [] edge : roads) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
		}

		int maxEdgeSum = 0;
		for(int i = 0; i < n - 1; i++) {
			if(edgeList[i] == null) continue;
			for(int j = i + 1; j < n; j++) {
				if(edgeList[j] == null) continue;
				int edgeSum = edgeList[i].size() + edgeList[j].size();
				if(edgeList[i].contains(j)) edgeSum--;
				maxEdgeSum = Math.max(maxEdgeSum, edgeSum);
			}
		}

		return maxEdgeSum;
	}
}
