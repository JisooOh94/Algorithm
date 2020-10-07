package medium.The_Earliest_Moment_When_Everyone_Become_Friends;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 5ms(96.81%)
 * Memory : 39.4mb(87.25%)
 */
public class Solution_2 {
	private static final int FROM = 1;
	private static final int TO = 2;

	private int findRoot(Integer[] parentArr, int elem) {
		Integer curParent = elem;
		while(parentArr[curParent] != null) curParent = parentArr[curParent];
		return curParent;
	}

	public int earliestAcq(int[][] logs, int N) {
		Arrays.sort(logs, (e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : 0);

		Integer[] parentArr = new Integer[N];
		int componentCnt = N;
		for(int[] log : logs) {
			int fromRoot = findRoot(parentArr, log[FROM]);
			int toRoot = findRoot(parentArr, log[TO]);

			if(fromRoot != toRoot) {
				parentArr[toRoot] = fromRoot;
				if(--componentCnt == 1) return log[0];
			}
		}
		return -1;
	}
}
