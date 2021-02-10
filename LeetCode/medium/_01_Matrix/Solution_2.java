package medium._01_Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 13ms(70.61%)
 * Memory : 42.9mb(34.93%)
 * Time Complexity : O(n)
 */
public class Solution_2 {
	private int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public int[][] updateMatrix(int[][] matrix) {
		int[][] memo = new int[matrix.length][matrix[0].length];

		Queue<int[]> queue = new LinkedList<>();
		for(int y = 0; y < matrix.length; y++) {
			for(int x = 0; x < matrix[0].length; x++) {
				if(matrix[y][x] == 1) {
					for(int i = 0; i < 4; i++) {
						int neighborY = y + dir[i][0];
						int neighborX = x + dir[i][1];
						if(0 <= neighborY && neighborY < matrix.length && 0 <= neighborX && neighborX < matrix[0].length && matrix[neighborY][neighborX] == 0) {
							memo[y][x] = 1;
							queue.offer(new int[]{y, x});
							break;
						}
					}
				}
			}
		}

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			for(int i = 0; i < 4; i++) {
				int neighborY = cur[0] + dir[i][0];
				int neighborX = cur[1] + dir[i][1];
				if(0 <= neighborY && neighborY < matrix.length && 0 <= neighborX && neighborX < matrix[0].length && matrix[neighborY][neighborX] == 1 && memo[neighborY][neighborX] == 0) {
					memo[neighborY][neighborX] = memo[cur[0]][cur[1]] + 1;
					queue.offer(new int[]{neighborY, neighborX});
				}
			}
		}

		return memo;
	}
}
