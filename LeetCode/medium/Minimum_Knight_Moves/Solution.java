package medium.Minimum_Knight_Moves;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 140ms(73.11%)
 * Memory : 45.5mb(76.31%)
 * Time Complexity : ?
 */
public class Solution {
	private int[][] dirArr = new int[][]{
			{-2, -1},
			{-2, 1},
			{-1, 2},
			{1, 2},
			{2, 1},
			{2, -1},
			{1, -2},
			{-1, -2}
	};

	public int minKnightMoves(int targetX, int targetY) {
		if(targetY == 0 && targetX == 0) return 0;
		boolean[][] visited = new boolean[601][601];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{300, 300});
		visited[300][300] = true;
		targetX += 300;
		targetY += 300;

		int steps = 0;
		while(!queue.isEmpty()) {
			steps++;
			int curCnt = queue.size();
			for(int loop = 0; loop < curCnt; loop++) {
				int[] cur = queue.poll();
				for(int[] dir : dirArr) {
					int nextY = cur[0] + dir[0];
					int nextX = cur[1] + dir[1];

					if(0 <= nextY && nextY <= 600 && 0 <= nextX && nextX <= 600 && !visited[nextY][nextX]) {
						if(nextY == targetY && nextX == targetX) return steps;
						visited[nextY][nextX] = true;
						queue.offer(new int[]{nextY, nextX});
					}
				}
			}
		}
		return -1;
	}
}
