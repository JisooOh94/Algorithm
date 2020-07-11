package medium.Maximum_Number_of_Events_That_Can_Be_Attended;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Runtime : 117ms(37.01%)
 * Memory : 115.3mb(8.88%)
 */
public class Solution_3 {
	@Test
	public void test() {
		//int[][] events = new int[][]{{1,2},{2,3},{3,4}};
		//int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
		//int[][] events = new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}};
		//int[][] events = new int[][]{{1,100000}};
		//int[][] events = new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
		//int[][] events = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}};
		//int[][] events = new int[][]{{1,2},{1,2},{3,3},{1,5},{1,5}};
		int[][] events = new int[][]{{25,26},{19,19},{9,13},{16,17},{17,18},{20,21},{22,25},{11,12},{19,23},{7,9},{1,1},{21,23},{14,14},{4,7},{16,16},{24,28},{16,18},{4,5},{18,20},{16,16},{25,26}};

		System.out.println(maxEvents(events));
	}

	public int maxEvents(int[][] events) {
		Arrays.sort(events, (e1, e2) -> e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : 0);

		int eventCnt = 0;
		int curDay = events[0][0];
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(events[0][1]);

		for(int i = 1; i < events.length; i++) {
			if(curDay != events[i][0]) {
				for(int idx = curDay; idx < events[i][0]; idx++) {
					while(!queue.isEmpty() && queue.peek() < curDay) queue.poll();
					if(queue.isEmpty()) break;
					queue.poll();
					eventCnt++;
					curDay++;
				}
				curDay = events[i][0];
			}
			queue.offer(events[i][1]);
		}

		while(!queue.isEmpty()) {
			while(!queue.isEmpty() && queue.peek() < curDay) queue.poll();
			if(!queue.isEmpty()) {
				queue.poll();
				eventCnt++;
				curDay++;
			}
		}

		return eventCnt;
	}
}
