package medium.Sell_Diminishing_Valued_Colored_Balls;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * TLE
 */
public class Solution {
	@Test
	public void executor() {
		int[] inventory = {1000000000, 1};
		int orders = 1000000000;

		System.out.println(maxProfit(inventory, orders));
	}
	public int maxProfit(int[] inventory, int orders) {
		PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for(int item : inventory) queue.offer((long)item);

		long profit = 0;
		for(int i = 0; i < orders; i++) {
			long maxVal = queue.poll();
			profit += maxVal;
			queue.offer(maxVal - 1);
		}
		return (int)(profit % (Math.pow(10, 9) + 7));
	}
}
