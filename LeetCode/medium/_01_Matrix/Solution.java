package medium._01_Matrix;

public class Solution {
	private int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	private int recursion(int y, int x, int[][] matrix, int[][] memo, boolean[][] visited) {
		if (matrix[y][x] == 0) return 0;
		else if (memo[y][x] != 0) return memo[y][x];

		int minDist = 999999;
		visited[y][x] = true;
		for (int i = 0; i < dir.length; i++) {
			int nextY = y + dir[i][0];
			int nextX = x + dir[i][1];
			if (0 <= nextY && nextY < matrix.length && 0 <= nextX && nextX < matrix[0].length && !visited[nextY][nextX]) {
				int curDist = recursion(y + dir[i][0], x + dir[i][1], matrix, memo, visited) + 1;
				minDist = Math.min(minDist, curDist);
			}
		}

		memo[y][x] = minDist;
		return minDist;
	}

	public int[][] updateMatrix(int[][] matrix) {
		int[][] memo = new int[matrix.length][matrix[0].length];

		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[0].length; x++) {
				if (matrix[y][x] != 0 && memo[y][x] == 0)
					recursion(y, x, matrix, memo, new boolean[matrix.length][matrix[0].length]);
			}
		}
		return memo;
	}
}