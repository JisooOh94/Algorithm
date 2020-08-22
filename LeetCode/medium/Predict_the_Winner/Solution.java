package medium.Predict_the_Winner;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1, 5, 2};
		System.out.println(PredictTheWinner(nums));
	}
	private int recursion(int left, int right, int turn, int totalScore, int[] arr, Integer[][][] record) {
		if(right == left) return 0;
		else if(record[left][right][turn] != null) return record[left][right][turn];

		int leftScore = arr[left] + recursion(left + 1, right, (turn + 1) % 2, totalScore - arr[left], arr, record);
		int rightScore = arr[right] + recursion(left, right - 1, (turn + 1) % 2, totalScore - arr[right], arr, record);

		int maxScore = Math.max(leftScore, rightScore);

		record[left][right][turn] = maxScore;
		return maxScore;
	}
	public boolean PredictTheWinner(int[] nums) {
		Integer[][][] record = new Integer[nums.length][nums.length][2];
		int totalScore = 0;
		for(int num : nums) totalScore += num;
		return recursion(0, nums.length - 1, 0, totalScore, nums, record) >= totalScore / 2;
	}
}
