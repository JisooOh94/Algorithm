package medium.Find_the_Most_Competitive_Subsequence;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 311ms(5.24%)
 * Memory : 126.6mb(5.12%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{3,5,2,6}; int k = 2;
		int[] nums = new int[]{2,4,3,3,5,4,9,6}; int k = 4;
		System.out.println(mostCompetitive(nums, k));
	}

	public int[] mostCompetitive(int[] nums, int k) {
		int prevIdx;
		int[] result = new int[k];
		int resultIdx = 0;

		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : 0);

		for(int i = 0; i < nums.length - k; i++) {
			queue.offer(new int[]{nums[i], i});
		}

		while(0 < k) {
			int nextIdx = nums.length - k;
			queue.offer(new int[]{nums[nextIdx], nextIdx});

			int[] minVal = queue.poll();
			result[resultIdx++] = minVal[0];
			prevIdx = minVal[1];

			while(!queue.isEmpty() && queue.peek()[1] < prevIdx) queue.poll();
			k--;
		}

		return result;
	}
}
