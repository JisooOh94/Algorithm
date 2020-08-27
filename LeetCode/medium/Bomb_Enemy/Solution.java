package medium.Bomb_Enemy;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
//		char[][] grid = new char[][]{
//				{'0','E','0','0'},
//				{'E','0','W','E'},
//				{'0','E','0','0'}
//		};
//		char[][] grid = new char[][]{{'E'}};
		char[][] grid = new char[][]{
				{'0','E','0','0'},
				{'E','0','W','E'},
				{'0','E','0','0'}
		};

		System.out.println(maxKilledEnemies(grid));
	}
	public int maxKilledEnemies(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int[][][] memo = new int[grid.length + 1][grid[0].length + 1][2];
		int maxCnt = 0;

		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				switch (grid[y][x]) {
					case '0' :
						memo[y + 1][x + 1][0] = memo[y + 1][x][0];
						memo[y + 1][x + 1][1] = memo[y][x + 1][1];
						maxCnt = Math.max(maxCnt, memo[y + 1][x + 1][0] + memo[y + 1][x + 1][1]);
						break;
					case 'W' :
						memo[y + 1][x + 1][0] = memo[y + 1][x + 1][1] = 0;
						break;
					case 'E' :
						memo[y + 1][x + 1][0] = memo[y + 1][x][0] + 1;
						memo[y + 1][x + 1][1] = memo[y][x + 1][1] + 1;
						break;
				}
			}
		}
		return maxCnt;
	}
}
