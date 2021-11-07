package medium.Largest_Number;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 8ms(52.74%)
 * Memory : 38.7mb(62.11%
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{0,0};
		System.out.println(largestNumber(nums));
	}
	public String largestNumber(int[] nums) {
		PriorityQueue<String> queue = new PriorityQueue<>((e1, e2) -> Long.compare(Long.parseLong(e1 + e2), Long.parseLong(e2 + e1)) * -1);
		for(int num : nums) queue.offer(String.valueOf(num));
		if(queue.peek().equals("0")) return "0";
		StringBuilder builder = new StringBuilder();
		while(!queue.isEmpty()) builder.append(queue.poll());
		return builder.toString();
	}
}
