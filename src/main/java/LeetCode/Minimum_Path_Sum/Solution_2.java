package LeetCode.Minimum_Path_Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import util.Predicate;

/**
 * Runtime : 158ms(5.67%)
 * Memory : 42mb(87.84)
 */
public class Solution_2 implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return minPathSum((int[][]) params[0]);
	}

	public class Pos {
		public int x;
		public int y;
		public int sum;

		public Pos(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}

	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		} else if(grid.length == 1) {
			return Arrays.stream(grid[0]).sum();
		} else if(grid[0].length == 1) {
			return Arrays.stream(grid).mapToInt(arr -> arr[0]).sum();
		}

		int width = grid[0].length;
		int height = grid.length;

		int[][] minGrid = new int[grid.length][grid[0].length];
		for(int[] arr : minGrid) {
			Arrays.fill(arr, -1);
		}

		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0,0, grid[0][0]));

		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int i = 0; i < size; i++) {
				Pos cur = queue.poll();

				if(minGrid[cur.y][cur.x] != -1 && minGrid[cur.y][cur.x] < cur.sum)
					continue;

				if(cur.x < width - 1)  {
					int sum = cur.sum + grid[cur.y][cur.x + 1];
					Pos newPos = new Pos(cur.x + 1, cur.y, sum);
					if(minGrid[newPos.y][newPos.x] == -1 || sum < minGrid[newPos.y][newPos.x]) {
						minGrid[newPos.y][newPos.x] = sum;
					}
					queue.offer(newPos);
				}

				if(cur.y < height - 1) {
					int sum = cur.sum + grid[cur.y + 1][cur.x];
					Pos newPos = new Pos(cur.x, cur.y + 1, sum);
					if(minGrid[newPos.y][newPos.x] == -1 || sum < minGrid[newPos.y][newPos.x]) {
						minGrid[newPos.y][newPos.x] = sum;
					}
					queue.offer(newPos);
				}
			}
		}

		return minGrid[height - 1][width - 1];
	}
}
