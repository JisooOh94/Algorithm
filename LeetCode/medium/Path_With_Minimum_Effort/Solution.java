package medium.Path_With_Minimum_Effort;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 170ms(17.53%)
 * Memory : 41.2mb(21.02%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] heights = new int[][]{
//				{1,2,2},{3,8,2},{5,3,5}
//		};

//		int[][] heights = new int[][]{
//				{1,2,3},{3,8,4},{5,3,5}
//		};

		int[][] heights = new int[][]{
				{2,3,6,3,6,6,1,2},{4,5,6,5,5,10,1,2},{9,1,4,10,4,7,7,3}
//				{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}
		};
		System.out.println(minimumEffortPath(heights));
	}

	private Integer[] find(int curY, int curX, Integer[][][] parentArr) {
		while(parentArr[curY][curX][0] != null) {
			Integer[] next = parentArr[curY][curX];
			curY = next[0];
			curX = next[1];
		}

		return new Integer[]{curY, curX};
	}

	public int minimumEffortPath(int[][] heights) {
		int ySize = heights.length;
		int xSize = heights[0].length;

		Integer[] start = new Integer[]{0,0};
		Integer[] dest = new Integer[]{ySize - 1, xSize - 1};

		Integer[][][] parentArr = new Integer[ySize][xSize][2];
		PriorityQueue<int[]> edgeQueue = new PriorityQueue<>((e1, e2) -> e1[4] > e2[4] ? 1 : e1[4] < e2[4] ? -1 : 0);

		for(int y = 0; y < ySize; y++) {
			for(int x = 0; x < xSize; x++) {
				if(y != ySize - 1) edgeQueue.offer(new int[]{y, x, y + 1, x, Math.abs(heights[y][x] - heights[y + 1][x])});
				if(x != xSize - 1) edgeQueue.offer(new int[]{y, x, y, x + 1, Math.abs(heights[y][x] - heights[y][x + 1])});
			}
		}

		while(!edgeQueue.isEmpty()) {
			int[] edge = edgeQueue.poll();
			int toY = edge[0]; int toX = edge[1];
			int fromY = edge[2]; int fromX = edge[3];

			Integer[] parent = find(toY, toX, parentArr);
			Integer[] child = find(fromY, fromX, parentArr);

			if(!Arrays.equals(parent, child)) {
				parentArr[child[0]][child[1]] = parent;
				if (Arrays.equals(child, start)) {
					start = parent;
					if (Arrays.equals(find(start[0], start[1], parentArr), dest)) return edge[4];
				} else if (Arrays.equals(child, dest)) {
					dest = parent;
					if (Arrays.equals(find(dest[0], dest[1], parentArr), start)) return edge[4];
				}
			}
		}
		return 0;
	}
}
