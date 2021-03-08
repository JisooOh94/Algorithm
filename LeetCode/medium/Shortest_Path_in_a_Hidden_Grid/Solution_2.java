package medium.Shortest_Path_in_a_Hidden_Grid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 63ms(100.00%)
 * Memory : 87.8mb(100.00%)
 * Time Complexity : O(n)
 */
interface GridMaster {
	boolean canMove(char direction);

	void move(char direction);

	boolean isTarget();
};

public class Solution_2 {
	private static final int EMPTY = 0;
	private static final int OBSTACLE = 1;
	private static final int START = -1;
	private static final int TARGET = 2;

	private static final int[][] dirArr = new int[][]{
			{(int) 'U', -1, 0},
			{(int) 'L', 0, -1},
			{(int) 'D', 1, 0},
			{(int) 'R', 0, 1}
	};

	private void recursion(int curY, int curX, Integer[][] map, GridMaster gridMaster) {
		if(gridMaster.isTarget()) {
			map[curY][curX] = TARGET;
			return;
		}

		for(int i = 0; i < dirArr.length; i++) {
			int[] dir = dirArr[i];
			int nextY = curY + dir[1];
			int nextX = curX + dir[2];

			if(map[nextY][nextX] == null) {
				if(gridMaster.canMove((char)dir[0])) {
					gridMaster.move((char)dir[0]);
					map[nextY][nextX] = EMPTY;
					recursion(nextY, nextX, map, gridMaster);
					gridMaster.move((char) dirArr[(i + 2) % 4][0]);
				} else {
					map[nextY][nextX] = OBSTACLE;
				}
			}
		}
	}

	public int findShortestPath(GridMaster master) {
		Integer[][] map = new Integer[999][999];
		int startX, startY;
		startX = startY = 499;
		map[startY][startX] = START;

		recursion(startY, startX, map, master);

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startY, startX});
		map[startY][startX] = null;

		int moveCnt = 0;
		while(!queue.isEmpty()) {
			moveCnt++;
			int nodeCnt = queue.size();
			for(int i = 0; i < nodeCnt; i++) {
				int[] cur = queue.poll();
				for(int[] dir : dirArr) {
					int nextY = cur[0] + dir[1];
					int nextX = cur[1] + dir[2];

					if(map[nextY][nextX] != null) {
						if (map[nextY][nextX] == TARGET) return moveCnt;
						else if (map[nextY][nextX] == EMPTY) {
							map[nextY][nextX] = null;
							queue.offer(new int[]{nextY, nextX});
						}
					}
				}
			}
		}

		return -1;
	}
}
