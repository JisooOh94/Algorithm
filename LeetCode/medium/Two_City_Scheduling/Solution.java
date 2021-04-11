package medium.Two_City_Scheduling;

import java.util.Arrays;

/**
 * Runtime : 2ms(30.72%)
 * Memory : 36.6mb(96.55%
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	private static final int A = 0;
	private static final int B = 1;
	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, (e1, e2) -> Math.abs(e1[A] - e1[B]) > Math.abs(e2[A] - e2[B]) ? 1 : Math.abs(e1[A] - e1[B]) < Math.abs(e2[A] - e2[B]) ? -1 : 0);
		int aCnt = costs.length / 2;
		int bCnt = costs.length / 2;

		int totalCost = 0;
		for(int[] cost : costs) {
			if(aCnt == 0) {
				totalCost += cost[B];
			} else if(bCnt == 0) {
				totalCost += cost[A];
			} else if(cost[A] < cost[B]) {
				totalCost += cost[A];
				aCnt--;
			} else {
				totalCost += cost[B];
				bCnt--;
			}
		}

		return totalCost;
	}
}
