package medium.Maximum_Non_Negative_Product_in_a_Matrix;

import org.junit.Test;

/**
 * Runtime : 2ms(71.26%)
 * Memory : 38.3mb(99.80%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] grid = new int[][]{
//				{-1, -2, -3},
//				{-2, -3, -3},
//				{-3, -3, -2}
//		};
//		int[][] grid = new int[][]{
//				{1,-2,1},
//		{1,-2,1},
//		{3,-4,1}
//		};
		int[][] grid = new int[][]{
				{ 1, 4,4,0},
		{-2, 0,0,1},
		{ 1,-1,1,1}
		};
		System.out.println(maxProductPath(grid));
	}

	private static final long MOD = (long)(Math.pow(10, 9) + 7);
	private long recursion(int curY, int curX, int minusCnt, int[][] map, Long[][][] record) {
		if(curY == map.length - 1 && curX == map[0].length - 1) return map[curY][curX];
		else if(record[curY][curX][minusCnt % 2] != null ) return record[curY][curX][minusCnt % 2];

		int curMinusCnt = map[curY][curX] < 0 ? minusCnt + 1 : minusCnt;
		int sign = minusCnt % 2 == 0 ? 1 : -1;

		long maxProduct = -999999;
		if(curY + 1 < map.length) maxProduct = Math.max(maxProduct, sign * map[curY][curX] * recursion(curY + 1, curX, curMinusCnt, map, record));
		if(curX + 1 < map[0].length) maxProduct = Math.max(maxProduct, sign * map[curY][curX] * recursion(curY, curX + 1, curMinusCnt, map, record));

		record[curY][curX][minusCnt % 2] = maxProduct * sign;
		return maxProduct * sign;
	}
	public int maxProductPath(int[][] grid) {
		Long[][][] record = new Long[grid.length][grid[0].length][2];
		long result = recursion(0,0,0, grid, record);
		return result < 0 ? -1 : (int)(result % MOD);
	}
}
