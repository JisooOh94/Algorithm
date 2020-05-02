package LeetCode.Number_of_Islands;

import java.util.LinkedList;
import java.util.Queue;

import util.Predicate;

/**
 * Runtime : 4ms(18.25%)
 * Memory : 42.1mb(33.96%)
 */
public class Solution implements Predicate<Integer, Object> {
	@Override
	public Integer test(Object... params) {
		return numIslands((char[][])params[0]);
	}

	private int[][] neighbor = new int[][] {
			{1, 0},		//down
			{-1, 0},	//up
			{0, 1},		//right
			{0, -1}		//left
	};

	public class Pos {
		public int x;
		public int y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

		boolean[][] visited =new boolean[grid.length][grid[0].length];
		Queue<Pos> posQ = new LinkedList<>();
		int islandCnt = 0;

		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == '1' && !visited[y][x]) {
					islandCnt++;
					visited[y][x] = true;
					posQ.offer(new Pos(y, x));

					while(!posQ.isEmpty()) {
						Pos cur = posQ.poll();

						for(int i = 0; i < 4; i++) {
							int newX = cur.x + neighbor[i][1];
							int newY = cur.y + neighbor[i][0];

							if(0 <= newX && newX < grid[0].length && 0 <= newY &&newY < grid.length && grid[newY][newX] == '1' && !visited[newY][newX]) {
								visited[newY][newX] = true;
								posQ.offer(new Pos(newY, newX));
							}
						}
					}

				}
			}
		}

		return islandCnt;
	}
}
