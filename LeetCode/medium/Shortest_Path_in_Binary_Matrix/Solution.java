package medium.Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 11ms(87.35%)
 * Memory : 40.1mb(85.15%)
 * Time Complexity : O(n)
 */
public class Solution {
	private static final int ABLE = 0;
	private static final int UNABLE = 1;
	int[][] dirArr = new int[][]{
			{1,0},
			{-1,0},
			{0,1},
			{0,-1},
			{1,1},
			{1,-1},
			{-1,1},
			{-1,-1}
	};

	public int shortestPathBinaryMatrix(int[][] grid) {
		if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
		else if(grid.length == 1 && grid[0].length == 1) return 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0});
		grid[0][0] = UNABLE;

		int pathLen = 1;
		while(!queue.isEmpty()) {
			pathLen++;
			int curCnt = queue.size();
			for(int loop = 0; loop < curCnt; loop++) {
				int[] cur = queue.poll();
				for(int[] dir : dirArr) {
					int nextY = cur[0] + dir[0];
					int nextX = cur[1] + dir[1];
					if(0 <= nextY && nextY < grid.length && 0 <= nextX && nextX < grid[0].length && grid[nextY][nextX] == ABLE) {
						if(nextY == grid.length - 1 && nextX == grid[0].length - 1) return pathLen;
						queue.offer(new int[]{nextY, nextX});
						grid[nextY][nextX] = UNABLE;
					}
				}
			}
		}
		return -1;
	}
}
