package medium.Path_with_Maximum_Probability;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 49ms(59.63%%)
 * Memory : 53.2mb(32.67%)
 * Subject : bellmanFord
 */
public class Solution_2 {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		double[] maxProb = new double[n];
		List<Object[]>[] edgeList = new LinkedList[n];

		for(int i = 0; i < edges.length; i++) {
			if(edgeList[edges[i][0]] == null) edgeList[edges[i][0]] = new LinkedList<>();
			if(edgeList[edges[i][1]] == null) edgeList[edges[i][1]] = new LinkedList<>();

			edgeList[edges[i][0]].add(new Object[]{edges[i][1], succProb[i]});
			edgeList[edges[i][1]].add(new Object[]{edges[i][0], succProb[i]});
		}

		Queue<Object[]> queue = new LinkedList<>();
		queue.add(new Object[]{start, 1.0});

		while (!queue.isEmpty()) {
			Object[] curInfo = queue.poll();
			int curIdx = (int)curInfo[0];
			double curProb = (double)curInfo[1];

			if(edgeList[curIdx] != null) {
				for (Object[] neighbor : edgeList[curIdx]) {
					int neighborIdx = (int) neighbor[0];
					double neighborProb = (double) neighbor[1];

					if(maxProb[neighborIdx] >= curProb * neighborProb) continue;

					queue.offer(new Object[]{neighborIdx, curProb * neighborProb});
					maxProb[neighborIdx] = curProb * neighborProb;
				}
			}
		}
		return maxProb[end];
	}
}
