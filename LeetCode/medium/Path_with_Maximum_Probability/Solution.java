package medium.Path_with_Maximum_Probability;

import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity : O(n^2)
 * Space Complexity : O(n)
 * Runtime : 1156ms(5.02%)
 * Memory : 52.5mb(40.03%)
 * Subject : Dijkstra
 */
public class Solution {
	private int getMaxIdx(boolean[] visited, Double[] maxProb) {
		double max = 0;
		int maxIdx = -1;

		for(int i = 0; i < maxProb.length; i++) {
			if(!visited[i] && maxProb[i] != null && max < maxProb[i]) {
				max = maxProb[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Double[] maxProb = new Double[n];
		boolean[] visited = new boolean[n];
		List<Object[]>[] edgeList = new LinkedList[n];

		for(int i = 0; i < edges.length; i++) {
			if(edgeList[edges[i][0]] == null) edgeList[edges[i][0]] = new LinkedList<>();
			if(edgeList[edges[i][1]] == null) edgeList[edges[i][1]] = new LinkedList<>();

			edgeList[edges[i][0]].add(new Object[]{edges[i][1], succProb[i]});
			edgeList[edges[i][1]].add(new Object[]{edges[i][0], succProb[i]});
		}
		maxProb[start] = 1.0;
		maxProb[end] = 0.0;

		for(int i = 0; i < n; i++) {
			int maxidx = getMaxIdx(visited, maxProb);
			if(maxidx == -1) break;
			else if(maxidx == end) return maxProb[maxidx];
			else if(maxProb[maxidx] <= maxProb[end]) break;

			visited[maxidx] = true;
			if(edgeList[maxidx] != null) {
				for (Object[] neighbor : edgeList[maxidx]) {
					int neighborIdx = (int) neighbor[0];
					double neighborProb = (double) neighbor[1];
					if (!visited[neighborIdx])
						maxProb[neighborIdx] = maxProb[neighborIdx] == null ? maxProb[maxidx] * neighborProb : Math.max(maxProb[maxidx] * neighborProb, maxProb[neighborIdx]);
				}
			}
		}

		return maxProb[end];
	}
}
