package medium.Unique_Binary_Search_Trees;

import org.junit.Test;

/**
 * Runtiem : 0ms(100.00%)
 * Memory : 35.9mb(94.80%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 17;
		System.out.println(numTrees(n));
	}
	private int recursion(int startNum, int endNum, Integer[][] record) {
		if(endNum < startNum) return 1;
		else if(record[startNum][endNum] != null) return record[startNum][endNum];

		int cnt = 0;
		for(int i = startNum; i <= endNum; i++) {
			cnt += recursion(startNum, i - 1, record) * recursion(i + 1, endNum, record);
		}
		record[startNum][endNum] = cnt;
		return cnt;
	}
	public int numTrees(int n) {
		Integer[][] record = new Integer[n + 1][n + 1];
		return recursion(1, n, record);
	}
}
