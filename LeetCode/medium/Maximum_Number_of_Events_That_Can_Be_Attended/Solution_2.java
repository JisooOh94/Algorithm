package medium.Maximum_Number_of_Events_That_Can_Be_Attended;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Solution_2 {
	@Test
	public void test() {
//		int[][] events = new int[][]{{1,2},{2,3},{3,4}};
		//int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
//		int[][] events = new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}};
//		int[][] events = new int[][]{{1,100000}};
		//int[][] events = new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
		int[][] events = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}};
		System.out.println(maxEvents(events));
	}

	public int maxEvents(int[][] events) {
		Arrays.sort(events, (e1, e2) -> e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : 0);
		List<int[]> minList = new LinkedList<>();
		minList.add(events[0]);
		int prevStartTime = events[0][0];
		for(int[] event : events) {
			if(event[0] != prevStartTime) {
				minList.add(event);
				prevStartTime = event[0];
			}
		}

		Arrays.sort(events, (e1, e2) -> e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : 0);


		int eventCnt = 0;
		int curIdx = 0;
		int minIdx = 0;

		int curDay = ((LinkedList<int[]>) minList).getFirst()[0];

		while(curIdx < events.length) {
			if(curDay < events[curIdx][0]) {
				for(int i = minIdx; i < minList.size(); i++) {

				}
			} else if(events[curIdx][0] <= curDay && curDay <= events[curIdx][1]) {
				eventCnt++;
				curDay++;
			}
			curIdx++;
		}

		return eventCnt;
	}
}
