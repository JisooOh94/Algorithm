package medium.Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 58ms(58.78%)
 * Memory : 107.6mb(5.73%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] connections = new int[][]{
				{0,1},{1,3},{2,3},{4,0},{4,5}
		};
		int n = 6;

		System.out.println(minReorder(n, connections));
	}
	private static final int CONNECTED_IDX = 0;
	private static final int DIRECTION_IDX = 1;
	private int recursion (int from, List<int[]>[] edgeInfo, boolean[] visited) {
		int changeCnt = 0;
		visited[from] = true;
		for(int[] connectionInfo : edgeInfo[from]) {
			if(visited[connectionInfo[CONNECTED_IDX]]) continue;
			if(connectionInfo[DIRECTION_IDX] != from) changeCnt++;
			changeCnt += recursion(connectionInfo[CONNECTED_IDX], edgeInfo, visited);
		}
		return changeCnt;
	}
	public int minReorder(int n, int[][] connections) {
		List<int[]>[] edgeInfo = new LinkedList[n];
		boolean[] visited = new boolean[n];

		for(int[] connection : connections) {
			int from = connection[0];
			int to = connection[1];

			if(edgeInfo[from] == null) edgeInfo[from] = new LinkedList<>();
			if(edgeInfo[to] == null) edgeInfo[to] = new LinkedList<>();

			edgeInfo[from].add(new int[]{to, to});
			edgeInfo[to].add(new int[]{from, to});
		}

		return recursion(0, edgeInfo, visited);
	}
}
