package medium.Least_Number_of_Unique_Integers_after_K_Removals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Runtime : 47ms(77.26%)
 * Memory : 49.4mb(82.71%)
 * Time Comlexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> histo = new HashMap<>();
		for(int num : arr) {
			if(histo.containsKey(num)) histo.compute(num, (key, val) -> val + 1);
			else histo.put(num, 1);
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int val : histo.values()) queue.offer(val);

		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur >= k) return cur == k ? queue.size() : queue.size() + 1;
			else k -= cur;
		}
		return 0;
	}
}
