package medium.Perfect_Squares;

import org.junit.Test;

/**
 * Runtime : 27ms(83.54%)
 * Memory : 40.3mb(33.54%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int n = 13;
//		int n = 2;
//		int n = 8285;
//		int n = 5238;
		System.out.println(numSquares(n));
	}
	public int numSquares(int n) {
		int[] record = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			int minCnt = 999999;
			for(int j = 1; j * j <= i; j++) {
				minCnt = Math.min(minCnt, 1 + record[i - j * j]);
			}
			record[i] = minCnt;
		}

		return record[n];
	}
}