package medium.Maximum_Number_of_Eaten_Apples;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 30ms(98.24%)
 * Memory : 40.5mb(82.35%)
 * Time Complexity : O(c)
 * subject : greedy
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[] cnt = new int[]{1,2,3,5,2};
//		int[] day = new int[]{3,2,1,4,2};
//		int[] cnt = new int[]{2,1,10};
//		int[] day = new int[]{2,10,1};
		int[] cnt = new int[]{3,0,0,0,0,2};
		int[] day = new int[]{3,0,0,0,0,2};
		System.out.println(eatenApples(cnt, day));
	}

	public int eatenApples(int[] cnt, int[] day) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : 0);
		int sum = 0;
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] != 0) queue.offer(new int[]{i + day[i] - 1, cnt[i]});
			while(!queue.isEmpty()) {
				int[] min = queue.peek();
				if(min[0] >= i && min[1] > 0) {
					sum++;
					min[1]--;
					break;
				} else {
					queue.poll();
				}
			}
		}

		int leftIdx = cnt.length;
		while(!queue.isEmpty()) {
			int[] min = queue.peek();
			if(min[0] >= leftIdx && min[1] > 0) {
				sum++;
				min[1]--;
				leftIdx++;
			} else {
				queue.poll();
			}
		}
		return sum;
	}
}
