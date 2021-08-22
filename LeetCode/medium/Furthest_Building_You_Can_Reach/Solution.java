package medium.Furthest_Building_You_Can_Reach;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 14ms(84.33%)
 * Memory : 49.4mb(86.39%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] height = new int[]{4,12,2,7,3,18,20,3,19};
		int brickCnt = 10;
		int ladderCnt = 2;
		System.out.println(furthestBuilding(height, brickCnt, ladderCnt));
	}

	public int furthestBuilding(int[] heights, int brickCnt, int ladderCnt) {
		int gapSum = 0;
		int ladderSum = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		int prev = heights[0];
		for(int i = 1; i < heights.length; i++) {
			if(prev < heights[i]) {
				int gap = heights[i] - prev;
				gapSum += gap;
				if(ladderCnt > 0) {
					if (queue.size() == ladderCnt) {
						if (queue.peek() < gap) {
							ladderSum += gap - queue.poll();
							queue.offer(gap);
						}
					} else {
						ladderSum += gap;
						queue.offer(gap);
					}
				}
				if(gapSum - ladderSum > brickCnt) return i - 1;
			}
			prev = heights[i];
		}
		return heights.length - 1;
	}
}
