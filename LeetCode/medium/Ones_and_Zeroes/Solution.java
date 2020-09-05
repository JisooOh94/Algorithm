package medium.Ones_and_Zeroes;

import org.junit.Test;

/**
 * Runtime : 91ms(37.19%)
 * Memory : 67mb(41.96%)
 */
public class Solution {
	@Test
	public void execute() {
//		String[] strs = new String[]{"10","0001","111001","1","0"}; int m = 5; int n = 3;
		String[] strs = new String[]{"10","0","1"}; int m = 1; int n = 1;
		System.out.println(findMaxForm(strs, m, n));
	}
	private int recursion(int idx, int m, int n, int[][] nrr, Integer[][][] record) {
		if(idx == nrr.length) return 0;
		else if(record[idx][m][n] != null) return record[idx][m][n];

		int max = 0;
		if(nrr[idx][0] <= m && nrr[idx][1] <= n) max = 1 + recursion(idx + 1, m - nrr[idx][0], n - nrr[idx][1], nrr, record);
		max = Math.max(recursion(idx + 1, m, n , nrr, record), max);

		record[idx][m][n] = max;
		return max;
	}
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] nrr = new int[strs.length][2];
		for(int i = 0; i < strs.length; i++) {
			for(int j = 0; j < strs[i].length(); j++) {
				switch (strs[i].charAt(j)) {
					case '0' : nrr[i][0]++; break;
					case '1' : nrr[i][1]++; break;
				}
			}
		}
		Integer[][][] record = new Integer[strs.length][m + 1][n + 1];

		return recursion(0, m, n, nrr, record);
	}
}
