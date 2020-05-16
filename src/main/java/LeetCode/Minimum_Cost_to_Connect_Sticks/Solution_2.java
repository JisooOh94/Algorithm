package LeetCode.Minimum_Cost_to_Connect_Sticks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;
import util.Predicate;

/**
 * Runtime : 17ms(97.94%
 * Memory : 40.3mb(100.0%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
	@Test
	public Integer test(Object... params) {
		return connectSticks((int[]) params[0]);
	}

	public int connectSticks(int[] sticks) {
		if (sticks.length == 1) return 0;
		else if (sticks.length == 2) return sticks[0] + sticks[1];

		Arrays.sort(sticks);

		Queue<Integer> sumQueue = new LinkedList<>();
		sumQueue.offer(sticks[0] + sticks[1]);

		int totalCost = sticks[0] + sticks[1];

		int idx = 2;
		while(idx < sticks.length) {
			int cost = 0;
			if(idx + 1 < sticks.length && sticks[idx + 1] < sumQueue.peek()) {
				cost = sticks[idx] + sticks[idx + 1];
				idx += 2;
			} else if(sticks[idx] < sumQueue.peek()) {
				cost = sticks[idx] + sumQueue.poll();
				idx += 1;
			} else {
				cost = sumQueue.poll() + ((sumQueue.isEmpty() || sticks[idx] < sumQueue.peek()) ? sticks[idx++] : sumQueue.poll());
			}
			totalCost += cost;
			sumQueue.offer(cost);
		}

		while(sumQueue.size() != 1) {
			int cost = sumQueue.poll() + sumQueue.poll();
			sumQueue.offer(cost);
			totalCost += cost;
		}
		return totalCost;
	}
}
