package easy.Climbing_Stairs;

import org.junit.Test;

/**
 * DP(Top-Down)
 * Runtime : 0ms(100.00%)
 * Memory : 37.9mb(5.11%)
 */
public class Solution_DP_TD {
	@Test
	public void execute() {
		int n = 6;
		System.out.println(climbStairs(n));
	}
	private int recursion(int cur, int dest, int[] record) {
		if(dest - 1 <= cur) return 1;
		else if(record[cur] != 0) return record[cur];
		record[cur] = recursion(cur + 1, dest, record) + recursion(cur + 2, dest, record);
		return record[cur];
	}
	public int climbStairs(int n) {
		int[] record = new int[n];
		return recursion(0, n, record);
	}
}
