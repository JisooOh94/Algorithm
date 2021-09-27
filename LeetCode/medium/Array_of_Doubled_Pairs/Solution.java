package medium.Array_of_Doubled_Pairs;

import java.util.LinkedList;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 57ms(46.82%)
 * Memory : 41.1mb(99.67%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] arr = new int[]{2,3,4,6};
		System.out.println(canReorderDoubled(arr));
	}
	public boolean canReorderDoubled(int[] arr) {
		PriorityQueue<Integer> posQueue = new PriorityQueue<>();
		PriorityQueue<Integer> negQueue = new PriorityQueue<>();
		LinkedList<Integer> stack = new LinkedList<>();
		for(int val : arr) {
			if(val >= 0) posQueue.offer(val);
			else negQueue.offer(val * -1);
		}

		while(!posQueue.isEmpty()) {
			int val = posQueue.poll();
			if(stack.isEmpty()) stack.addLast(val);
			else if(stack.getFirst() * 2 < val) return false;
			else if(stack.getFirst() * 2 == val) stack.removeFirst();
			else stack.addLast(val);
		}

		if(!stack.isEmpty()) return false;
		stack = new LinkedList<>();

		while(!negQueue.isEmpty()) {
			int val = negQueue.poll();
			if(stack.isEmpty()) stack.addLast(val);
			else if(stack.getFirst() * 2 < val) return false;
			else if(stack.getFirst() * 2 == val) stack.removeFirst();
			else stack.addLast(val);
		}
		return stack.isEmpty();
	}
}
