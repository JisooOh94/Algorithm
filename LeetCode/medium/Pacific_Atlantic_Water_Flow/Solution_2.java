package medium.Pacific_Atlantic_Water_Flow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Solution_2 {
	@Test
	public void execute() {
		int[][] map = new int[][]{
				{1, 2, 2, 3, 5},
				{3, 2, 3, 4, 4},
				{2, 4, 5, 3, 1},
				{6, 7, 1, 4, 5},
				{5, 1, 1, 2, 4}
		};
//		int[][] map = new int[][]{
//				{10,10, 10}, {10,1, 10},{10,10, 10}
//		};
//		int[][] map = new int[][]{{3,3,3,3},{3,3,0,3},{3,3,3,3}};

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

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
		else if(matrix.length == 1 && matrix[0].length == 1) return Arrays.asList(Arrays.asList(0, 0));

		int height = matrix.length;
		int width = matrix[0].length;

		List<List<Integer>> bothFloodList = new LinkedList<>();
		int[][] memo = new int[height][width];
		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> matrix[e1[0]][e1[1]] > matrix[e2[0]][e2[1]] ? 1 : matrix[e1[0]][e1[1]] < matrix[e2[0]][e2[1]] ? -1 : 0);

		for(int y = 0; y < height; y++) {
			memo[y][0] = PACIFIC;
			memo[y][width - 1] = ATLANTIC;
			queue.offer(new int[]{y, 0});
			queue.offer(new int[]{y, width - 1});
		}

		for(int x = 0; x < width; x++) {
			memo[0][x] = PACIFIC;
			memo[height - 1][x] = ATLANTIC;
			queue.offer(new int[]{0, x});
			queue.offer(new int[]{height - 1, x});
		}

		bothFloodList.add(Arrays.asList(height - 1, 0));
		bothFloodList.add(Arrays.asList(0, width - 1));
		memo[height - 1][0] = memo[0][width - 1] = BOTH;

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			for(int i = 0; i < 4; i++) {
				int nextY = cur[0] + dir[i][0];
				int nextX = cur[1] + dir[i][1];

				if(0 <= nextY && nextY < height && 0 <= nextX && nextX < width &&
						matrix[nextY][nextX] >= matrix[cur[0]][cur[1]] && memo[nextY][nextX] != BOTH) {
					if (memo[nextY][nextX] == 0) {
						memo[nextY][nextX] = memo[cur[0]][cur[1]];
						queue.offer(new int[]{nextY, nextX});
					}
					else if (memo[nextY][nextX] != memo[cur[0]][cur[1]]) {
						memo[nextY][nextX] = BOTH;
						bothFloodList.add(Arrays.asList(nextY, nextX));
					}
				}
			}
		}


		bothFloodList.sort((e1, e2) -> e1.get(0) > e2.get(0) ? 1 : e1.get(0) < e2.get(0) ? -1 : e1.get(1) > e2.get(1) ? 1 : e1.get(1) < e2.get(1) ? -1 : 0);
		return bothFloodList;
	}
}
