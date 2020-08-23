package medium.Greatest_Sum_Divisible_by_Three;

import org.junit.Test;

public class Answer {
	@Test
	public void execute() {
		int[] nums = new int[]{1,2,3,4,4};
		System.out.println(maxSumDivThree(nums));
	}
	public int maxSumDivThree(int[] nums) {
		int[] sum = new int[3];
		sum[1] = -1;
		sum[2] = -1;
		for (int num : nums) {
			int[] temp = new int[3];
			temp[0] = sum[0];
			temp[1] = sum[1];
			temp[2] = sum[2];

			if (temp[(3 - num%3)%3] != -1)
				sum[0] = Math.max(sum[0], temp[(3 - num%3)%3] + num);

			if (temp[(4 - num%3)%3] != -1)
				sum[1] = Math.max(sum[1], temp[(4 - num%3)%3] + num);

			if (temp[(5 - num%3)%3] != -1)
				sum[2] = Math.max(sum[2], temp[(5 - num%3)%3] + num);
		}
		return sum[0];
	}
}
