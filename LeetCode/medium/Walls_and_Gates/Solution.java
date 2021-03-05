package medium.Walls_and_Gates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 8ms(54.33%)
 * Memory : 42.5mb(74.44%)
 * Time Complexity : O(n)
 */
public class Solution {
	private static final int GATE = 0;
	private static final int EMPTY = 2147483647;
	private static final int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public void wallsAndGates(int[][] rooms) {
		Queue<int[]> queue = new LinkedList<>();
		int height = rooms.length;
		int width = rooms[0].length;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(rooms[y][x] == GATE) {
					queue.offer(new int[]{y, x});
				}
			}
		}

		int dist = 0;
		while(!queue.isEmpty()) {
			dist++;
			int curNodeCnt = queue.size();
			for(int loop = 0; loop < curNodeCnt; loop++) {
				int[] cur = queue.poll();
				for(int i = 0; i < 4; i++) {
					int nextY = cur[0] + dir[i][0];
					int nextX = cur[1] + dir[i][1];

					if(0 <= nextY && nextY < height && 0 <= nextX && nextX < width && rooms[nextY][nextX] == EMPTY) {
						rooms[nextY][nextX] = dist;
						queue.offer(new int[]{nextY, nextX});
					}
				}
			}
		}
	}
}
