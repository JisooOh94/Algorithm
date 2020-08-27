package medium.Bomb_Enemy;

import java.util.LinkedList;

import org.junit.Test;

/**
 * Runtime : 18ms(13.30%)
 * Memory : 46.3mb(47.10%)
 */
public class Solution_2 {
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
		int maxCnt = 0;
		LinkedList<Integer>[] yEmptyList = new LinkedList[grid[0].length];
		int[] yEnemyCnt = new int[grid[0].length];
		Integer[][][] memo = new Integer[grid.length][grid[0].length][2];
		for(int y = 0; y < grid.length; y++) {
			LinkedList<Integer> xEmptyList = new LinkedList<>();
			int xEnemyCnt = 0;
			for(int x = 0;  x < grid[0].length; x++) {
				if(yEmptyList[x] == null) yEmptyList[x] = new LinkedList<>();
				switch (grid[y][x]) {
					case '0' :
						yEmptyList[x].add(y);
						xEmptyList.add(x);
						break;
					case 'E' :
						xEnemyCnt++;
						yEnemyCnt[x]++;
						break;
					case 'W' :
						for(int xIdx : xEmptyList) {
							memo[y][xIdx][1] = xEnemyCnt;
							if(memo[y][xIdx][0] != null) maxCnt = Math.max(maxCnt, memo[y][xIdx][0] + memo[y][xIdx][1]);
						}
						for(int yIdx : yEmptyList[x]) {
							memo[yIdx][x][0] = yEnemyCnt[x];
							if(memo[yIdx][x][1] != null) maxCnt = Math.max(maxCnt, memo[yIdx][x][0] + memo[yIdx][x][1]);
						}
						xEmptyList.clear();
						yEmptyList[x].clear();
						yEnemyCnt[x] = xEnemyCnt = 0;
						break;
				}

				if(grid[y][x] != 'W' && x == grid[0].length - 1) {
					for(int xIdx : xEmptyList) {
						memo[y][xIdx][1] = xEnemyCnt;
						if(memo[y][xIdx][0] != null) maxCnt = Math.max(maxCnt, memo[y][xIdx][0] + memo[y][xIdx][1]);
					}
				}
				if(grid[y][x] != 'W' && y == grid.length - 1) {
					for(int yIdx : yEmptyList[x]) {
						memo[yIdx][x][0] = yEnemyCnt[x];
						if(memo[yIdx][x][1] != null) maxCnt = Math.max(maxCnt, memo[yIdx][x][0] + memo[yIdx][x][1]);
					}
				}
			}
		}
		return maxCnt;
	}
}
