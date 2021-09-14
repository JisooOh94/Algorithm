package medium.Most_Profit_Assigning_Work;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;
import javafx.util.Pair;

/**
 * Runtime : 48ms(40.86%)
 * Memory : 60.3mb(7.60%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] difficulty = new int[]{2,4,6,8,10};
		int[] profit = new int[]{10,20,30,40,50};
		int[] worker = new int[]{4,5,6,7};
		System.out.println(maxProfitAssignment(difficulty, profit, worker));
	}
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		Arrays.sort(worker);
		PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getValue() > e2.getValue() ? -1 : e1.getValue() < e2.getValue() ? 1 : 0);
		for(int i = 0; i < profit.length; i++) {
			queue.offer(new Pair<>(i, profit[i]));
		}

		int totalProfit = 0;
		Pair<Integer, Integer> cur = queue.poll();
		for(int i = worker.length - 1; 0 <= i; i--) {
			while(cur != null && worker[i] < difficulty[cur.getKey()]) cur = queue.poll();
			if(cur == null) break;
			totalProfit += cur.getValue();
		}
		return totalProfit;
	}
}
