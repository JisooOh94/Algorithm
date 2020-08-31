package medium.Largest_Plus_Sign;

import org.junit.Test;

/**
 * Runtime : 28ms()
 * Memory : 42.1mb()
 */
public class Solution {
	@Test
	public void execute() {
//		int rng = 5; int[][] mines = new int[][]{ {4, 2} };
		int rng = 3; int[][] mines = new int[][]{{0,0}};
		System.out.println(orderOfLargestPlusSign(rng, mines));
	}

	public int orderOfLargestPlusSign(int rng, int[][] mines) {
		if(mines.length == rng * rng) return 0;

		int[][] grid = new int[rng][rng];
		for(int[] pos : mines) grid[pos[0]][pos[1]] = -1;
		int maxLength = 1;
		int[][][] memo = new int[rng][rng][2];
		for(int y = 0; y < rng; y++) {
			for(int x = 0; x < rng; x++) {
				if(grid[y][x] == 0) {
					int xPrev = x == 0 ? 0 : memo[y][x - 1][1];
					int yPrev = y == 0 ? 0 : memo[y - 1][x][0];

					int xJumpIdx = x + xPrev;
					if(xJumpIdx == rng || grid[y][xJumpIdx] != 0) memo[y][x][1] = xPrev - 1;
					else if(xJumpIdx + 1 < rng && grid[y][xJumpIdx + 1] == 0) memo[y][x][1] = xPrev + 1;
					else memo[y][x][1] = xPrev;

					int yJumpIdx = y + yPrev;
					if(yJumpIdx == rng || grid[yJumpIdx][x] != 0) memo[y][x][0] = yPrev - 1;
					else if(yJumpIdx + 1 < rng && grid[yJumpIdx + 1][x] == 0) memo[y][x][0] = yPrev + 1;
					else memo[y][x][0] = yPrev;

					maxLength = Math.max(maxLength, Math.min(memo[y][x][0], memo[y][x][1]));
				}
			}
		}

		return maxLength;
	}
}