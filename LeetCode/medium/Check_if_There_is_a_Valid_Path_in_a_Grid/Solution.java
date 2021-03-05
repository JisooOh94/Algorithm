package medium.Check_if_There_is_a_Valid_Path_in_a_Grid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 18ms(49.04%)
 * Memory : 50.9mb(92.31%)
 * Time Complexity : O(n)
 */
public class Solution {
	private int[][][] dirArr = new int[][][]{
		{
			{0, 0}
		}, {
			{0, -1},
			{0, 1},
		}, {
			{-1, 0},
			{1, 0}
		}, {
			{0, -1},
			{1, 0},
		}, {
			{0, 1},
			{1, 0}
		}, {
			{0, -1},
			{-1, 0}
		}, {
			{0, 1},
			{-1, 0}
		}
	};

	private List<Integer>[][] pairArr = new List[][]{
			{},
			{Arrays.asList(1, 4, 6), Arrays.asList(1, 3, 5)},
			{Arrays.asList(2, 3, 4), Arrays.asList(2, 5, 6)},
			{Arrays.asList(1, 4, 6), Arrays.asList(2, 5, 6)},
			{Arrays.asList(1, 3, 5), Arrays.asList(2, 5, 6)},
			{Arrays.asList(1, 4, 6), Arrays.asList(2, 3, 4)},
			{Arrays.asList(1, 3, 5), Arrays.asList(2, 3, 4)}
	};

	public boolean hasValidPath(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		if(height == 1 && width == 1) return true;

		boolean[][] visited = new boolean[height][width];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{0, 0});
		visited[0][0] = true;

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curRoad = grid[cur[0]][cur[1]];

			for(int i = 0; i < 2; i++) {
				int[] dir = dirArr[curRoad][i];
				List<Integer> pair = pairArr[curRoad][i];
				int nextY = cur[0] + dir[0];
				int nextX = cur[1] + dir[1];

				if(0 <= nextY && nextY < height && 0 <= nextX && nextX < width) {
					if(!visited[nextY][nextX] && pair.contains(grid[nextY][nextX])) {
						if (nextY == height - 1 && nextX == width - 1) return true;
						visited[nextY][nextX] = true;
						queue.offer(new int[]{nextY, nextX});
					}
				}
			}
		}
		return false;
	}
}
