package medium.Path_with_Maximum_Probability;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 42ms(79.45%)
 * Memory : 54.9mb(20.26%)
 */
public class Solution_3 {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Double[] maxProb = new Double[n];
		List<Object[]>[] edgeList = new LinkedList[n];
		Queue<Integer> queue = new LinkedList<>();

		for(int i = 0; i < edges.length; i++) {
			if(edgeList[edges[i][0]] == null) edgeList[edges[i][0]] = new LinkedList<>();
			if(edgeList[edges[i][1]] == null) edgeList[edges[i][1]] = new LinkedList<>();

			edgeList[edges[i][0]].add(new Object[]{edges[i][1], succProb[i]});
			edgeList[edges[i][1]].add(new Object[]{edges[i][0], succProb[i]});
		}
		maxProb[start] = 1.0;
		maxProb[end] = 0.0;

		queue.offer(start);

		while(!queue.isEmpty()) {
			int cur = queue.poll();

			if(edgeList[cur] != null) {
				for (Object[] neighbor : edgeList[cur]) {
					int neighborIdx = (int) neighbor[0];
					double neighborProb = (double) neighbor[1];

					if (maxProb[neighborIdx] != null && maxProb[neighborIdx] >= maxProb[cur] * neighborProb) continue;

					maxProb[neighborIdx] = maxProb[cur] * neighborProb;
					queue.offer(neighborIdx);
				}
			}
		}

		return maxProb[end];
	}
}
