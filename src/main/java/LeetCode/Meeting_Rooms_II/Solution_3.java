package LeetCode.Meeting_Rooms_II;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import util.Predicate;

/**
 * Runtime : 8ms(23.71%)
 * Memory : 39.7mb(11.54%)
 */
public class Solution_3 implements Predicate<Integer, Object> {
	@Override
	public Integer test(Object... params) {
		return minMeetingRooms((int[][])params[0]);
	}

	public int minMeetingRooms(int[][] roomTimeArr) {
		if(roomTimeArr == null || roomTimeArr.length == 0) return 0;
		else if(roomTimeArr.length == 1) return 1;

		Arrays.sort(roomTimeArr, (time_1, time_2) -> time_1[0] > time_2[0] ? 1 : time_1[0] < time_2[0] ? -1 : 0);
		TreeMap<Integer, Integer> roomEndTimeList = new TreeMap<>();
		roomEndTimeList.put(roomTimeArr[0][1], 1);
		int duplication = 0;

		for(int i = 1; i < roomTimeArr.length; i++) {
			int roomStartT = roomTimeArr[i][0];
			int roomEndT = roomTimeArr[i][1];

			Map.Entry<Integer, Integer> entry = roomEndTimeList.firstEntry();

			if(roomStartT >= entry.getKey()) {
				if(entry.getValue() == 1) {
					roomEndTimeList.pollFirstEntry();
				} else {
					roomEndTimeList.put(entry.getKey(), entry.getValue() - 1);
					duplication--;
				}
			}

			int cnt = roomEndTimeList.getOrDefault(roomEndT, 0);
			if(cnt != 0) duplication++;
			roomEndTimeList.put(roomEndT, cnt + 1);
		}

		return roomEndTimeList.size() + duplication;
	}
}
