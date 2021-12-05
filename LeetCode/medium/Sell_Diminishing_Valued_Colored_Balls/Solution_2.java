package medium.Sell_Diminishing_Valued_Colored_Balls;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * time : 71ms(17.12%)
 * Memory : 54.3mb(39.89%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution_2 {
	@Test
	public void test() {
		long result = (773160767L + (773160767L - 252264991L + 1)) * 252264991L / 2L;
		long result2 = result % (long)(Math.pow(10, 9) + 7);
		System.out.println(result2);
	}
	@Test
	public void executor() {
		int[] inventory = {773160767};
		int orders = 252264991;

		System.out.println(maxProfit(inventory, orders));
	}
	public int maxProfit(int[] inventory, int orders) {
		PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for(int item : inventory) queue.offer((long)item);

		long maxVal = queue.poll();
		int maxCnt = 1;
		long profit = 0;

		while(0 < orders) {
			if(!queue.isEmpty() && queue.peek() == maxVal) {
				maxCnt++;
				queue.poll();
			} else {
				long nextMax = queue.isEmpty() ? 0 : queue.peek();
				long gap = maxVal - nextMax;
				if(gap * maxCnt <= orders) {
					long gapSum = (maxVal + nextMax + 1) * gap / 2;
					profit += gapSum * maxCnt;
					maxVal = nextMax;
					orders -= gap * maxCnt;
				} else {
					int full = orders / maxCnt;
					int part = orders % maxCnt;
					nextMax = maxVal - full;
					long fullGapSum = (maxVal + nextMax + 1) * full / 2;
					long partGapSum = nextMax * part;
					profit += fullGapSum * maxCnt + partGapSum;
					orders = 0;
				}
			}
		}

		return (int)(profit % (long)(Math.pow(10, 9) + 7));
	}
}
