package medium.Min_Cost_to_Connect_All_Points;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 79ms(74.29%)
 * Memory : 61mb(53.47%)
 * Subject : kruskal
 */
public class Solution {
	@Test
	public void execute() {
		int[][] points = new int[][]{
				{0,0},{2,2},{3,10},{5,2},{7,0}
		};
		System.out.println(minCostConnectPoints(points));
	}
	private int getParent(int cur, Integer[] parent) {
		while(parent[cur] != null) cur = parent[cur];
		return cur;
	}
	public int minCostConnectPoints(int[][] points) {
		if(points.length == 1) return 0;
		PriorityQueue<int[]> edgeList = new PriorityQueue<>((e1, e2) -> e1[2] > e2[2] ? 1 : e1[2] < e2[2] ? -1 : 0);

		for(int i = 0; i < points.length - 1; i++) {
			for(int j = i + 1; j < points.length; j++) {
				int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				edgeList.add(new int[]{i, j, dist});
			}
		}

		int pointCnt = points.length;
		Integer[] parent = new Integer[pointCnt];
		int edgeLen = 0;
		while(!edgeList.isEmpty()) {
			int[] edge = edgeList.poll();
			int parentPoint = getParent(edge[0], parent);
			int childPoint = getParent(edge[1], parent);

			if(parentPoint != childPoint) {
				parent[childPoint] = parentPoint;
				edgeLen += edge[2];
				if(--pointCnt == 1) break;
			}
		}
		return edgeLen;
	}
}
