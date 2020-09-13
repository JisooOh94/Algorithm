package medium.Coin_Change;

import org.junit.Test;

/**
 * Runtime : 38ms(16.28%)
 * Memory : 40.8mb(30.57%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] coins = new int[]{1, 2, 5}; int amount = 11;
		int[] coins = new int[]{346,29,395,188,155,109}; int amount = 9401;
		System.out.println(coinChange(coins, amount));
	}
	private static final int IMPOSSIBLE = 999999;
	private int recursion(int curIdx, int target, int[] nums, Integer[][] record) {
		if(target == 0) return 0;
		else if(target < 0) return IMPOSSIBLE;
		else if(record[curIdx][target] != null) return record[curIdx][target];

		int minCnt = curIdx == nums.length - 1 ? 1 + recursion(curIdx, target - nums[curIdx], nums, record) : Math.min(1 + recursion(curIdx, target - nums[curIdx], nums, record), recursion(curIdx + 1, target, nums, record));

		record[curIdx][target] = minCnt;
		return minCnt;
	}

	public int coinChange(int[] coins, int amount) {
		if(amount == 0) return 0;
		else if(coins == null || coins.length == 0) return -1;

//		Arrays.sort(coins);
		Integer[][] record = new Integer[coins.length][amount + 1];

		int result = Math.min(recursion(0, amount, coins, record), IMPOSSIBLE);
		return result == IMPOSSIBLE ? -1 : result;
	}
}
