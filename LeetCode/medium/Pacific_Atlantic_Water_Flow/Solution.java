package medium.Pacific_Atlantic_Water_Flow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
//		int[][] map = new int[][]{
//				{1, 2, 2, 3, 5},
//				{3, 2, 3, 4, 4},
//				{2, 4, 5, 3, 1},
//				{6, 7, 1, 4, 5},
//				{5, 1, 1, 2, 4}
//		};
		int[][] map = new int[][]{
				{10,10, 10}, {10,1, 10},{10,10, 10}
		};

		System.out.println(pacificAtlantic(map));
	}

	private static final int PACIFIC = 1;
	private static final int ATLANTIC = 2;
	private static final int BOTH = 3;
	private static final int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	int width, height;

	private Integer recursion(int curY, int curX, int[][] map, Integer[][] memo, boolean[][] visited, List<List<Integer>> bothFloodList) {
		if (curY == -1 || curY == height || curX == -1 || curX == width) return curY == -1 || curX == -1 ? PACIFIC : ATLANTIC;
		else if (memo[curY][curX] != null) return memo[curY][curX];
		else if (visited[curY][curX]) return null;

		Integer floodDir = null;
		visited[curY][curX] = true;
		for (int i = 0; i < 4; i++) {
			int nextY = curY + dir[i][0];
			int nextX = curX + dir[i][1];

			if ((nextY == -1 || nextY == height || nextX == -1 || nextX == width)
					|| (map[nextY][nextX] <= map[curY][curX])) {
				Integer curDir = recursion(nextY, nextX, map, memo, visited, bothFloodList);
				if(curDir != null)
					floodDir = floodDir == null ? curDir : floodDir != curDir ? BOTH : floodDir;
			}
		}

		if (floodDir != null) {
			memo[curY][curX] = floodDir;
			if (floodDir == BOTH) bothFloodList.add(Arrays.asList(curY, curX));
		}
		return floodDir;
	}

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
		height = matrix.length;
		width = matrix[0].length;
		Integer[][] memo = new Integer[height][width];
		List<List<Integer>> bothFloodList = new LinkedList<>();

		for (int y = 0; y < height; y++) memo[y] = new Integer[width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				recursion(y, x, matrix, memo, new boolean[height][width], bothFloodList);
			}
		}
		return bothFloodList;
	}
}
