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
			int left = dist[i] / speed[i];
			if(dist[i] % speed[i] != 0) left += 1;
			queue.offer(left);
		}

		int spendCost = 0;
		while(!queue.isEmpty()) {
			int left = queue.poll();
			if(left <= spendCost) return spendCost;
			spendCost++;
		}
		return dist.length;
	}
}
