package medium.Eliminate_Maximum_Number_of_Monsters;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 56ms(22.95%)
 * Memory : 55.9mb(58.08%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] dist = new int[]{1,1,2,3};
		int[] speed = new int[]{1,1,1,1};
		System.out.println(eliminateMaximum(dist, speed));
	}

	public int eliminateMaximum(int[] dist, int[] speed) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < dist.length; i++) {
			queue.offer(dist[i] / speed[i] + (dist[i] % speed[i] != 0 ? 1 : 0));
		}

		int spendCost = 0;
		while(!queue.isEmpty()) {
			if(queue.poll() <= spendCost) return spendCost;
			spendCost++;
		}

		return dist.length;
	}
}
