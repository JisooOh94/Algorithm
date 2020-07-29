package medium.Minimum_Cost_For_Tickets;

import org.junit.Test;

/**
 * Runtime : 1ms(87.82%)
 * Memory : 39mb(24.60%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] days = new int[]{1,4,6,7,8,20}; int[] costs = new int[]{2,7,15};
		int[] days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31}; int[] costs = new int[]{2,7,15};
		System.out.println(mincostTickets(days, costs));
	}
	private int minCostFind(int startIdx, int[] days, int[] costs, int[] period, int[] record) {
		if(record[startIdx] != 0) {
			return record[startIdx];
		}
		int minCost = 999999;
		for(int i = 0; i < 3; i++) {
			int curCost = costs[i];
			for(int j = startIdx + 1; j < days.length; j++) {
				if(days[startIdx] + period[i] <= days[j]) {
					curCost += minCostFind(j, days, costs, period, record);
					break;
				}
			}
			if(curCost < minCost) minCost = curCost;
		}
		record[startIdx] = minCost;
		return minCost;
	}

	public int mincostTickets(int[] days, int[] costs) {
		int[] period = new int[]{1, 7, 30};
		int[] record = new int[days.length];
		int result = minCostFind(0, days, costs, period, record);
		return result;
	}
}
