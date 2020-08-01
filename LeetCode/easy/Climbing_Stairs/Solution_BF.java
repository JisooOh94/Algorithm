package easy.Climbing_Stairs;

import org.junit.Test;

/**
 * Brute Force
 * TimeLimitExceed
 */
public class Solution_BF {
	@Test
	public void execute() {
		int n = 6;
		System.out.println(climbStairs(n));
	}
	private int recursion(int cur, int dest) {
		return dest - 1 <= cur ? 1 : recursion(cur + 1, dest) + recursion(cur + 2, dest);
	}
	public int climbStairs(int n) {
		return recursion(0, n);
	}
}
