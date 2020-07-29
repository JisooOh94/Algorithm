package medium.Minimum_Cost_For_Tickets;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.3mb(72.73%)
 */
public class Solution_2 {
	@Test
	public void bsTest() {
		int[] arr = new int[]{1,3,5,7,9};
		System.out.println(Arrays.binarySearch(arr, 10));
		System.out.println(Arrays.binarySearch(arr, 5, 6, 6));
	}
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
			int endDay = days[startIdx] + period[i];
			if(startIdx + 1 < days.length && endDay <= days[days.length - 1]) {
				int nextStartIdx = Arrays.binarySearch(days, startIdx + 1, days.length, endDay);
				if (nextStartIdx < 0) nextStartIdx = nextStartIdx * -1 - 1;
				curCost += minCostFind(nextStartIdx, days, costs, period, record);
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
