package medium.Possible_Bipartition;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 12ms(90.11%)
 * Memory : 47.7mb(41.77%)
 * Time Complexity : O(N*D)
 */
public class Solution {
	private static final int GROUP_A = 1;
	private static final int EMPTY = 0;
	private boolean marking(int cur, int[] groupArr, List<Integer>[] edgeList) {
		if(edgeList[cur] != null) {
			for (int neighbor : edgeList[cur]) {
				if (groupArr[neighbor] == EMPTY) {
					groupArr[neighbor] = groupArr[cur] * -1;
					if (!marking(neighbor, groupArr, edgeList)) return false;
				} else if (groupArr[neighbor] == groupArr[cur]) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean possibleBipartition(int N, int[][] dislikes) {
		if(N == 1 || dislikes == null || dislikes.length == 0) return true;
		int[] groupArr = new int[N + 1];
		List<Integer>[] edgeList = new LinkedList[N + 1];

		for(int[] edge : dislikes) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			if(edgeList[edge[1]] == null) edgeList[edge[1]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
		}

		for(int i = 1; i < N; i++) {
			if(groupArr[i] == EMPTY) {
				groupArr[i] = GROUP_A;
				if(!marking(i, groupArr, edgeList)) return false;
			}
		}

		return true;
	}
}
