package Minimum_Cost_to_Connect_Sticks;

import java.util.PriorityQueue;

import org.junit.Test;
import util.Predicate;

/**
 * Runtime : 62ms(80.0%)
 * Memory : 40.8mb(100.0%)
 */
public class Solution implements Predicate<Integer, Object> {
	@Test
	public Integer test(Object... params) {
		return connectSticks((int[]) params[0]);
	}

	public int connectSticks(int[] sticks) {
		if (sticks.length == 1) return 0;
		else if (sticks.length == 2) return sticks[0] + sticks[1];

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int num : sticks) {
			queue.add(num);
		}

		int totalCost = 0;

		for(int i = 0; i < sticks.length - 2; i++) {
			int combine = queue.poll() + queue.poll();
			totalCost += combine;
			queue.add(combine);
		}

		totalCost += queue.poll() + queue.poll();

		return totalCost;
	}
}
