package medium.As_Far_from_Land_as_Possible;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 12ms(83.78%)
 * Memory : 40.1mb(47.42%)
 * Time Complexity : O(n)
 * Subject : BFS
 */
public class Solution {
	private static final int LAND = 1;
	private static final int WATER = 0;
	int[][] neighbor = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public int maxDistance(int[][] grid) {
		int waterCnt = 0;
		Queue<int[]> landQueue = new LinkedList<>();
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == LAND) landQueue.offer(new int[]{y, x});
				else waterCnt++;
			}
		}

		if(waterCnt == 0 || landQueue.isEmpty()) return -1;

		int dist = 1;
		while(waterCnt > 1) {
			int size = landQueue.size();
			for(int i = 0; i < size; i++) {
				int[] cur = landQueue.poll();
				for(int j = 0; j < 4; j++) {
					int neighborY = cur[0] + neighbor[j][0];
					int neighborX = cur[1] + neighbor[j][1];

					if(0 <= neighborY && neighborY < grid.length && 0 <= neighborX && neighborX < grid[0].length && grid[neighborY][neighborX] == WATER) {
						grid[neighborY][neighborX] = LAND;
						waterCnt--;
						landQueue.offer(new int[]{neighborY, neighborX});
					}
				}
			}
			dist++;
		}
		return waterCnt == 0 ? dist - 1 : dist;
	}
}
