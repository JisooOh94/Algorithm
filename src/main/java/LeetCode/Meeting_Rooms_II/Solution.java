package LeetCode.Meeting_Rooms_II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;

/**
 * Runtime : 7ms(38.54%)
 * Memory : 39.2mb(17.95%)
 */
public class Solution implements Predicate<Integer, Object> {
	@Override
	public Integer test(Object... params) {
		return minMeetingRooms((int[][])params[0]);
	}

	public int minMeetingRooms(int[][] roomTimeArr) {
		if(roomTimeArr == null || roomTimeArr.length == 0) return 0;
		else if(roomTimeArr.length == 1) return 1;

		Arrays.sort(roomTimeArr, (time_1, time_2) -> time_1[0] > time_2[0] ? 1 : time_1[0] < time_2[0] ? -1 : 0);
		List<Integer> roomEndTimeList = new LinkedList<>();
		roomEndTimeList.add(roomTimeArr[0][1]);

		for(int i = 1; i < roomTimeArr.length; i++) {
			int roomStartT = roomTimeArr[i][0];
			int roomEndT = roomTimeArr[i][1];
			boolean modified = false;

			for(int j = 0; j < roomEndTimeList.size(); j++) {
				if(roomEndTimeList.get(j) <= roomStartT) {
					roomEndTimeList.set(j, roomEndT);
					modified = true;
					break;
				}
			}

			if(!modified) roomEndTimeList.add(roomEndT);
		}

		return roomEndTimeList.size();
	}
}
