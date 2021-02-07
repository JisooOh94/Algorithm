package medium.Pacific_Atlantic_Water_Flow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Solution_3 {
	@Test
	public void execute() {
//		int[][] map = new int[][]{
//				{1, 2, 2, 3, 5},
//				{3, 2, 3, 4, 4},
//				{2, 4, 5, 3, 1},
//				{6, 7, 1, 4, 5},
//				{5, 1, 1, 2, 4}
//		};
//		int[][] map = new int[][]{
//				{10,10, 10}, {10,1, 10},{10,10, 10}
//		};
//		int[][] map = new int[][]{{3,3,3,3},{3,3,0,3},{3,3,3,3}};

//		int[][] map = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
		int[][] map = new int[][]{
				{5, 10, 9, 0},
				{4, 3, 2, 1}
		};
		System.out.println(pacificAtlantic(map));
	}

	private static final int EMPTY = 0;
	private static final int PACIFIC = 1;
	private static final int ATLANTIC = 2;
	private static final int BOTH = 3;

	private static final int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
		else if(matrix.length == 1 && matrix[0].length == 1) return Arrays.asList(Arrays.asList(0, 0));

		int height = matrix.length;
		int width = matrix[0].length;

		List<List<Integer>> bothFloodList = new LinkedList<>();
		int[][] filed = new int[height][width];

		for(int y = 0; y < height; y++) {
			filed[y][0] = PACIFIC;
			filed[y][width - 1] = ATLANTIC;
		}

		for(int x = 0; x < width; x++) {
			filed[0][x] = PACIFIC;
			filed[height - 1][x] = ATLANTIC;
		}

		bothFloodList.add(Arrays.asList(height - 1, 0));
		bothFloodList.add(Arrays.asList(0, width - 1));
		filed[height - 1][0] = filed[0][width - 1] = BOTH;

		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (filed[y][x] == EMPTY || filed[y][x] == ATLANTIC) continue;
				for(int i = 0; i < 4; i++) {
					int nextY = y + dir[i][0];
					int nextX = x + dir[i][1];

					if(0 <= nextY && nextY < height && 0 <= nextX && nextX < width &&
						matrix[y][x] <= matrix[nextY][nextX]) {
						if(filed[nextY][nextX] == ATLANTIC) {
							bothFloodList.add(Arrays.asList(nextY, nextX));
							filed[nextY][nextX] = BOTH;
						}
						else if(filed[nextY][nextX] == EMPTY) filed[nextY][nextX] = PACIFIC;
					}
				}
			}
		}

		for(int y = height - 1; 0 <= y; y--) {
			for(int x = width - 1; 0 <= x; x--) {
				if(filed[y][x] == EMPTY || filed[y][x] == PACIFIC) continue;
				for(int i = 0; i < 4; i++) {
					int nextY = y + dir[i][0];
					int nextX = x + dir[i][1];

					if(0 <= nextY && nextY < height && 0 <= nextX && nextX < width &&
							matrix[y][x] <= matrix[nextY][nextX]) {
						if(filed[nextY][nextX] == PACIFIC) {
							bothFloodList.add(Arrays.asList(nextY, nextX));
							filed[nextY][nextX] = BOTH;
						}
						else if(filed[nextY][nextX] == EMPTY) filed[nextY][nextX] = ATLANTIC;
					}
				}
			}
		}

		bothFloodList.sort((e1, e2) -> e1.get(0) > e2.get(0) ? 1 : e1.get(0) < e2.get(0) ? -1 : e1.get(1) > e2.get(1) ? 1 : e1.get(1) < e2.get(1) ? -1 : 0);
		return bothFloodList;
	}
}
