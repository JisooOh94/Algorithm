package Number_of_Islands;

import java.util.LinkedList;
import java.util.Queue;

import util.Predicate;

/**
 * Runtime : 5ms(11.52%)
 * Memory : 41.8mb(51.63%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
	@Override
	public Integer test(Object... params) {
		return numIslands((char[][])params[0]);
	}

	private int[][][] neighbor = new int[][][] {
			//from : none
			{
					{-1, 0, 1},    //up
					{1, 0, 2},        //down
					{0, 1, 3},        //right
					{0, -1, 4}        //left
			},
			//from : down
			{
					{-1, 0, 1},    //up
					{0, 1, 3},        //right
					{0, -1, 4}        //left
			},
			//from : up
			{
					{1, 0, 2},        //down
					{0, 1, 3},        //right
					{0, -1, 4}        //left
			},
			//from : left
			{
					{1, 0, 2},        //down
					{-1, 0, 1},    //up
					{0, 1, 3},        //right
			},
			//from : right
			{
					{1, 0, 2},        //down
					{-1, 0, 1},    //up
					{0, -1, 4}        //left
			},
	};

	public class Pos {
		public int x;
		public int y;
		public int from;

		public Pos(int y, int x, int from) {
			this.x = x;
			this.y = y;
			this.from = from;
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
					posQ.offer(new Pos(y, x, 0));

					while(!posQ.isEmpty()) {
						Pos cur = posQ.poll();

						for(int i = 0; i < (cur.from == 0 ? 4 : 3); i++) {
							int newY = cur.y + neighbor[cur.from][i][0];
							int newX = cur.x + neighbor[cur.from][i][1];

							if(0 <= newX && newX < grid[0].length && 0 <= newY &&newY < grid.length && grid[newY][newX] == '1' && !visited[newY][newX]) {
								visited[newY][newX] = true;
								posQ.offer(new Pos(newY, newX, neighbor[cur.from][i][2]));
							}
						}
					}

				}
			}
		}

		return islandCnt;
	}
}
