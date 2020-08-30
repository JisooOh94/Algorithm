package medium.Last_Stone_Weight_II;

import org.junit.Test;

/**
 * Runtime : 1ms(99.53%)
 * Memory : 38.6mb(47.57%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] stones = new int[]{2,7,4,1,8,1};
//		int[] stones = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 14, 23, 37, 61, 98};
		System.out.println(lastStoneWeightII(stones));
	}

	private int recursion(int nextIdx, int curSum, int totalSum, int[] stones, Integer[][] memo) {
		if(nextIdx == stones.length) {
			return Math.abs(totalSum - curSum * 2);
		}
		else if(memo[nextIdx][curSum] != null) return memo[nextIdx][curSum];

		int minGap = Math.min(recursion(nextIdx + 1, curSum, totalSum, stones, memo), recursion(nextIdx + 1, curSum + stones[nextIdx], totalSum, stones, memo));
		memo[nextIdx][curSum] = minGap;
		return minGap;
	}

	public int lastStoneWeightII(int[] stones) {
		Integer[][] memo = new Integer[stones.length][100 * stones.length];
		int totalSum = 0;
		for(int num : stones) totalSum += num;
		int result = recursion(0, 0, totalSum, stones, memo);
		return result;
	}
}
