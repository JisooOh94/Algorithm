package easy.Climbing_Stairs;

import org.junit.Test;

/**
 * DP(Bottom-Up)
 * Runtime : 0ms(100.00%)
 * Memory : 38.6mb(5.11%)
 */
public class Solution_DP_BU {
	@Test
	public void execute() {
		int n = 6;
		System.out.println(climbStairs(n));
	}

	public int climbStairs(int n) {
		int[] record = new int[n + 1];
		record[0] = 1;
		record[1] = 1;

		for(int i = 2; i <= n; i++)
			record[i] = record[i - 1] + record[i - 2];
		return record[n];
	}
}
