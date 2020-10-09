package medium.Keys_and_Rooms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 1ms(86.66%)
 * Memory : 38.8mb(6.11%)
 */
public class Solution {
	@Test
	public void execute() {
		List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1,3),Arrays.asList(3,0,1),Arrays.asList(2),Arrays.asList(0));
		System.out.println(canVisitAllRooms(rooms));
	}
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int roomLeft = rooms.size();
		boolean[] visited = new boolean[roomLeft];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(0);
		visited[0] = true;
		roomLeft--;

		while(!queue.isEmpty() && 0 < roomLeft) {
			int curRoom = queue.poll();
			for(int nextRoomIdx : rooms.get(curRoom)) {
				if(!visited[nextRoomIdx]) {
					queue.offer(nextRoomIdx);
					roomLeft--;
					visited[nextRoomIdx] = true;
				}
			}
		}

		return roomLeft == 0;
	}
}
