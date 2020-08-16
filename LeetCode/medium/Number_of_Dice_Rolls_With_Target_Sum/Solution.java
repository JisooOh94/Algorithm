package medium.Number_of_Dice_Rolls_With_Target_Sum;

import org.junit.Test;

/**
 * Runtime : 1669ms(5.00%)
 * Memory : 38.7mb(59.32%)
 */
public class Solution {
	@Test
	public void execute() {
//		int d = 1; int f = 6; int target = 3;
//		int d = 2; int f = 6; int target = 7;
//		int d = 2; int f = 5; int target = 10;
//		int d = 1; int f = 2; int target = 3;
		int d = 30; int f = 30; int target = 500;
		System.out.println(numRollsToTarget(d, f, target));
	}

	private static final double MOD_NUM = Math.pow(10, 9) + 7;

	private int recursion(int target, int leftDice, int range, int[][] record) {
		if((double)target / (double)leftDice > (double)range || (target == 0 && leftDice != 0) || (target != 0 && leftDice == 0)) return 0;
		else if(target == 0 && leftDice == 0) return 1;
		else if(record[leftDice][target] != 0) return record[leftDice][target];

		int waySum = 0;

		for(int i = 1; i <= range && i <= target; i++) {
			waySum += recursion(target - i, leftDice - 1, range, record);
		}

		waySum %= MOD_NUM;
		record[leftDice][target] = waySum;

		return waySum;
	}

	public int numRollsToTarget(int d, int f, int target) {
		int[][] record = new int[d + 1][target + 1];
		return recursion(target, d, f, record);
	}
}
