package medium.Shortest_Path_to_Get_Food;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 4ms(100.00%)
 * Memory : 43.1mb(61.47%)
 * Time Complexity : O(n)
 */
public class Solution {
	private static final char START = '*';
	private static final char FOOD = '#';
	private static final char WALL = 'X';
	private static final int[][] dir = new int[][]{
			{1, 0},
			{0, 1},
			{-1, 0},
			{0, -1}
	};

	public int getFood(char[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();

		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(grid[y][x] == START) {
					queue.offer(new int[]{y, x});
					grid[y][x] = WALL;
					break;
				}
			}
			if(!queue.isEmpty()) break;
		}

		int length = 0;
		while(!queue.isEmpty()) {
			int nodeCnt = queue.size();
			for(int loop = 0; loop < nodeCnt; loop++) {
				int[] cur = queue.poll();
				for(int i = 0; i < 4; i++) {
					int nextY = cur[0] + dir[i][0];
					int nextX = cur[1] + dir[i][1];

					if(0 <= nextY && nextY < height && 0 <= nextX && nextX < width) {
						if (grid[nextY][nextX] == FOOD) return length + 1;
						else if (grid[nextY][nextX] != WALL) {
							queue.offer(new int[]{nextY, nextX});
							grid[nextY][nextX] = WALL;
						}
					}
				}
			}
			length++;
		}
		return -1;
	}
}
