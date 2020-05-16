package Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

import util.Predicate;

/**
 * Runtime : 3ms(78.04%)
 * Memory : 39.4mb(81.25%)
 */
public class Solution implements Predicate<Integer, Object> {
	@Override
	public Integer test(Object... params) {
		return orangesRotting((int[][])params[0]);
	}

	private static final int FRESH_ORAGNE = 1;
	private static final int ROTTEN_ORAGNE = 2;

	private int[][] direction = new int[][] {
			{-1,0},		//up
			{1,0},		//down
			{0,-1},		//left
			{0,1}		//right
	};

	private class Pos {
		int x;
		int y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public int orangesRotting(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
		else if(grid.length == 1 && grid[0].length == 1) return grid[0][0] == FRESH_ORAGNE ? -1 : 0;

		Queue<Pos> posQ = new LinkedList<>();
		int height = grid.length;
		int width = grid[0].length;

		int freshOrangeCnt = 0;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(grid[y][x] == FRESH_ORAGNE) freshOrangeCnt++;
				else if(grid[y][x] == ROTTEN_ORAGNE) posQ.offer(new Pos(y, x));
			}
		}

		int costDay = 0;
		int totalRottenTomatoCnt = 0;
		while(!posQ.isEmpty()) {
			if(totalRottenTomatoCnt == freshOrangeCnt) {
				break;
			}
			int dailyRottenTomatoCnt = posQ.size();
			costDay++;

			for(int i = 0; i < dailyRottenTomatoCnt; i++) {
				Pos cur = posQ.poll();
				for(int dirIdx = 0; dirIdx < 4; dirIdx++) {
					int newX = cur.x + direction[dirIdx][1];
					int newY = cur.y + direction[dirIdx][0];

					if(0 <= newX && newX < width && 0 <= newY && newY < height && grid[newY][newX] == FRESH_ORAGNE) {
						posQ.offer(new Pos(newY, newX));
						grid[newY][newX] = ROTTEN_ORAGNE;
						totalRottenTomatoCnt++;
					}
				}
			}
		}

		return totalRottenTomatoCnt == freshOrangeCnt ? costDay : -1;
	}
}
