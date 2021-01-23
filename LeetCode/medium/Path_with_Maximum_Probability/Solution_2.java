package medium.Path_with_Maximum_Probability;

import java.util.LinkedList;
import java.util.List;

/**
 * Time LImit Exceed
 */
public class Solution_2 {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Double[] maxProb = new Double[n];

		maxProb[start] = 1.0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < edges.length; i++) {
				int from = edges[j][0];
				int to = edges[j][1];

				if(maxProb[from] != null) {
					maxProb[to] = maxProb[to] == null ? maxProb[from] * succProb[j] : Math.max(maxProb[to], maxProb[from] * succProb[j]);
				}
				if(maxProb[to] != null) {
					maxProb[from] = maxProb[from] == null ? maxProb[to] * succProb[j] : Math.max(maxProb[from], maxProb[to] * succProb[j]);
				}
			}
		}

		return maxProb[end] == null ? 0 : maxProb[end];
	}
}
