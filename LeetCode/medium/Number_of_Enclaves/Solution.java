package medium.Number_of_Enclaves;

/**
 * Runtime : 9ms(18.24%)
 * Memory : 47.2mb(8.50%)
 */
public class Solution {
	boolean reachedBorder = false;
	private int[][] dir = new int[][]{
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};

	private int recursion(int y, int x, int[][] map) {
		if(y < 0 || y == map.length || x < 0 || x == map[0].length || map[y][x] == 0) return 0;
		if(y == 0 || y == map.length - 1 || x == 0 || x == map[0].length - 1) reachedBorder = true;

		map[y][x] = 0;
		int cnt = 1;

		for(int i = 0; i < 4; i++) cnt += recursion(y + dir[i][0], x + dir[i][1], map);
		return cnt;
	}
	public int numEnclaves(int[][] A) {
		int islandCnt = 0;
		for(int y = 0; y < A.length; y++) {
			for(int x = 0; x < A[0].length; x++) {
				if(A[y][x] == 1) {
					reachedBorder = false;
					int cnt = recursion(y, x, A);
					if(!reachedBorder) {
						islandCnt += cnt;
						reachedBorder = false;
					}
				}
			}
		}
		return islandCnt;
	}
}
