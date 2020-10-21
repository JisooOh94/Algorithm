package medium.Time_Needed_to_Inform_All_Employees;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 55ms(86.86%)
 * Memory : 56.5mb(5.48%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 15;
		int headId = 0;
		int[] manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
		int[] informTime = new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
		System.out.println(numOfMinutes(n, headId, manager, informTime));
	}
	private int recursion (int curIdx, List<Integer>[] childList, int costTIme, int[] cost) {
		if(childList[curIdx] == null) return costTIme;

		costTIme += cost[curIdx];
		int maxCostTime = costTIme;
		for(int childIdx : childList[curIdx]) {
			maxCostTime = Math.max(maxCostTime, recursion(childIdx, childList, costTIme,cost));
		}
		return maxCostTime;
	}

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		if(n == 1) return 0;
		List<Integer>[] childList = new LinkedList[n];
		for(int i = 0; i < manager.length; i++) {
			if(manager[i] == -1) continue;
			if(childList[manager[i]] == null) childList[manager[i]] = new LinkedList<>();
			childList[manager[i]].add(i);
		}

		return recursion(headID, childList, 0, informTime);
	}
}
