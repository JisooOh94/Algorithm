package medium.Find_Original_Array_From_Doubled_Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Runtime : 64ms(87.36%)
 * Memory : 56.3mb(77.15%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	private static final int[] EMPTY_ARR = new int[0];
	public int[] findOriginalArray(int[] changed) {
		if(changed.length % 2 != 0) return EMPTY_ARR;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int[] result = new int[changed.length / 2];
		int idx = 0;

		Arrays.sort(changed);
		queue.offer(changed[0] * 2);

		for(int i = 1; i < changed.length; i++) {
			int num = changed[i];
			if(queue.isEmpty() || num < queue.peek()) {
				queue.offer(num * 2);
			} else if(num == queue.peek()) {
				result[idx++] = num / 2;
				queue.poll();
			} else {
				return EMPTY_ARR;
			}
		}

		return idx == result.length ? result : EMPTY_ARR;
	}
}
