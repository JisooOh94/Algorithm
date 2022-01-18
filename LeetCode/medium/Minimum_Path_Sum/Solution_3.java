package medium.Minimum_Path_Sum;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 23ms(5.02%
 * Memory : 45.4mb(5.80%)
 * Time Complexity : O(nlogn)
 * Subject : dijkstra
 */
public class Solution_3 {
	@Test
	public void execute() {
//		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		int[][] grid = new int[][]{{1,2,3},{4,5,6}};
		System.out.println(minPathSum(grid));
	}
	private static final int Y = 0;
	private static final int X = 1;
	private static final int W = 2;
	public int minPathSum(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		Integer[][] minVal = new Integer[height][width];
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(val -> val[2]));
		minVal[0][0] = grid[0][0];
		queue.offer(new int[]{0,0,grid[0][0]});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			int downY = cur[Y] + 1;
			int downX = cur[X];
			if(downY < height && minVal[downY][downX] == null) {
				int weight = cur[W] + grid[downY][downX];
				minVal[downY][downX] = weight;
				queue.offer(new int[]{downY, downX, weight});
			}

			int rightY = cur[Y];
			int rightX = cur[X] + 1;
			if(rightX < width && minVal[rightY][rightX] == null) {
				int weight = cur[W] + grid[rightY][rightX];
				minVal[rightY][rightX] = weight;
				queue.offer(new int[]{rightY, rightX, weight});
			}
		}

		return minVal[height - 1][width - 1];
	}
}
