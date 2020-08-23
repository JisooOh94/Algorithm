package medium.Perfect_Squares;

import org.junit.Test;

/**
 * Runtime : 385ms(11.72%)
 * Memory : 42.4mb(15.45%)
 */
public class Solution {
	@Test
	public void execute() {
//		int n = 13;
//		int n = 2;
		int n = 8285;
//		int n = 5238;
		System.out.println(numSquares(n));
	}
	private boolean isPrime(int num) {
		return Math.sqrt(num) % 1 == 0.0;
	}

	public int numSquares(int n) {
		Integer[] record = new Integer[n + 1];
		return recursion(n, record);
	}

	private int recursion(int num, Integer[] record) {
		if(isPrime(num)) return 1;
		else if(record[num] != null) return record[num];

		int minCnt = 99999;
		for(int i = 1; i <= Math.sqrt(num); i++) {
			int curCnt = 1 + recursion(num - (int)Math.pow(i,2), record);
			minCnt = Math.min(minCnt, curCnt);
			if(minCnt == 2) break;
		}

		record[num] = minCnt;
		return minCnt;
	}

}
