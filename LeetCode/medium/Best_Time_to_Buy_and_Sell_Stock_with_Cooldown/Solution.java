package medium.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import org.junit.Test;

/**
 * Runtime : 1ms(81.54%)
 * Memory : 39.2mb(47.03%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] prices = new int[]{1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
	private static final int BUY = -1;
	private static final int SELL = 1;
	private int recursion(int idx, int status, int[] prices, Integer[][] record) {
		if(idx >= prices.length) return 0;
		else if(record[idx][status == -1 ? 0 : 1] != null) return record[idx][status == -1 ? 0 : 1];

		int maxProfit = prices[idx] * status + recursion(status == SELL ? idx + 2 : idx + 1, status * -1, prices, record);
		maxProfit = Math.max(maxProfit, recursion(idx + 1, status, prices, record));

		record[idx][status == -1 ? 0 : 1] = maxProfit;

		return maxProfit;
	}
	public int maxProfit(int[] prices) {
		Integer[][] record = new Integer[prices.length][2];
		return recursion(0, BUY, prices, record);
	}
}
