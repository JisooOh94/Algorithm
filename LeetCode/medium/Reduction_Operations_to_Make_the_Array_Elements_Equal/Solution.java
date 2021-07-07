package medium.Reduction_Operations_to_Make_the_Array_Elements_Equal;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 842ms(25.00%)
 * Memory : 116.3mb(25.00%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,1,2,2,3};
		System.out.println(reductionOperations(nums));
	}
	public int reductionOperations(int[] nums) {
		Map<Integer, Integer> pairCnt = new HashMap<>();
		for(int num : nums) {
			pairCnt.putIfAbsent(num, 0);
			pairCnt.compute(num, (k, v) -> v + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getKey() > e2.getKey() ? -1 : e1.getKey() < e2.getKey() ? 1 : 0);
		queue.addAll(pairCnt.entrySet());

		int operationCnt = 0;
		while(queue.size() > 1) {
			Map.Entry<Integer, Integer> biggest = queue.poll();
			Map.Entry<Integer, Integer> secondBiggest = queue.peek();
			operationCnt += biggest.getValue();
			secondBiggest.setValue(secondBiggest.getValue() + biggest.getValue());
		}

		return operationCnt;
	}
}
