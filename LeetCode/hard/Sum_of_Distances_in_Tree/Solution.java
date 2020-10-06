package hard.Sum_of_Distances_in_Tree;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 1701ms(5.08%)
 * Memory : 47.3mb(97.14%)
 */
public class Solution {
	@Test
	public void execute() {
//		int n = 7;
//		int[][] edges = new int[][]{
//				{0, 1},
//				{0, 2},
//				{1, 3},
//				{1, 4},
//				{2, 5},
//				{2, 6}
//		};

		int n = 6;
		int[][] edges = new int[][]{
				{0, 1},
				{0, 2},
				{2, 3},
				{2, 4},
				{2, 5},
		};

		sumOfDistancesInTree(n, edges);

		for(int sum : sumArr) System.out.println(sum);
	}
	private static final int SUM_IDX = 0;
	private static final int CNT_IDX = 1;

	private int[] sumArr;
	private int[][] distanceInfo;
	private int[] recursion_bottomUp (int curIdx, List<List<Integer>> childList, boolean[] visited) {
		visited[curIdx] = true;
		int[] curResult = new int[2];

		for(int childIdx : childList.get(curIdx)) {
			if(visited[childIdx]) continue;
			int[] childResult = recursion_bottomUp(childIdx, childList, visited);
			curResult[SUM_IDX] += childResult[SUM_IDX];
			curResult[CNT_IDX] += childResult[CNT_IDX];
		}

		sumArr[curIdx] += curResult[SUM_IDX];
		curResult[CNT_IDX] += 1;
		curResult[SUM_IDX] += curResult[CNT_IDX];

		distanceInfo[curIdx] = curResult;

		return curResult;
	}

	private void recursion_topDown(int curIdx, int parentDist, int accumDist, List<List<Integer>> childList, boolean[] visited) {
		visited[curIdx] = true;
		sumArr[curIdx] += parentDist;
		parentDist += accumDist;
		for(int childIdx : childList.get(curIdx)) {
			if(visited[childIdx]) continue;
			recursion_topDown(childIdx, parentDist + distanceInfo[curIdx][SUM_IDX] - (distanceInfo[childIdx][SUM_IDX] + distanceInfo[childIdx][CNT_IDX]), accumDist + (distanceInfo[curIdx][CNT_IDX] - distanceInfo[childIdx][CNT_IDX]), childList, visited);
		}
	}

	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		List<List<Integer>> childList = new LinkedList<>();
		for(int i = 0; i < N; i++) childList.add(new LinkedList<>());
		for(int[] edge : edges) {
			childList.get(edge[0]).add(edge[1]);
			childList.get(edge[1]).add(edge[0]);
		}
		sumArr = new int[N];
		distanceInfo = new int[N][2];

		boolean[] visited = new boolean[N];
		recursion_bottomUp(0, childList, visited);
		visited = new boolean[N];
		recursion_topDown(0, 0, 0, childList, visited);

		return sumArr;
	}
}
