package medium.Map_of_Highest_Peak;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 59ms(83.33%)
 * Memory : 146.2mb(100.00%)
 * Time Complexity : O(n)
 */
public class Solution {
	private static final int WATER = 1;
	private static final int LAND = 0;
	private static final int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public int[][] highestPeak(int[][] isWater) {
		int rowSize = isWater.length;
		int colSize = isWater[0].length;
		int[][] heightMap = new int[rowSize][colSize];
		Queue<int[]> queue = new LinkedList<>();

		for(int y = 0; y < rowSize; y++) {
			for(int x = 0; x < colSize; x++) {
				if(isWater[y][x] == WATER) {
					queue.offer(new int[]{y, x});
				}
			}
		}

		int height = 0;
		while(!queue.isEmpty()) {
			height++;
			int landCnt = queue.size();
			for(int loop = 0; loop < landCnt; loop++) {
				int[] cur = queue.poll();
				for(int i = 0; i < 4; i++) {
					int nextY = cur[0] + dir[i][0];
					int nextX = cur[1] + dir[i][1];
					if(0 <= nextY && nextY < rowSize && 0 <= nextX && nextX < colSize
							&& isWater[nextY][nextX] != WATER && heightMap[nextY][nextX] == 0) {
						heightMap[nextY][nextX] = height;
						queue.offer(new int[]{nextY, nextX});
					}
				}
			}
		}

		return heightMap;
	}
}
