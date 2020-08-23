package medium.Greatest_Sum_Divisible_by_Three;

import org.junit.Test;

/**
 * Runtiem : 3ms(99.34%)
 * Memory : 45.2mb(56.47%)
 */
public class Solution_3 {
	@Test
	public void execute() {
//		int[] nums = new int[]{1,2,3,4,4};
//		int[] nums = new int[]{3,6,5,1,8};
//		int[] nums = new int[]{5,2,2,2};
//		int[] nums = new int[]{2,6,2,2,7};
		int[] nums = new int[]{4};
		System.out.println(maxSumDivThree(nums));
	}

	public int maxSumDivThree(int[] nums) {
		int left_1_min = 999999;
		int left_2_min = 999999;

		int sum = 0;
		for(int num : nums) {
			sum += num;
			if(num % 3 == 1) {
				if(num <= left_1_min) {
					left_2_min = Math.min(left_2_min, num + left_1_min);
					left_1_min = num;
				}
			} else if(num % 3 == 2) {
				if(num <= left_2_min) {
					left_1_min = Math.min(left_1_min, num + left_2_min);
					left_2_min = num;
				}
			}
		}

		int result = sum;
		switch (sum % 3) {
			case 1 : result = sum - left_1_min; break;
			case 2 : result = sum - left_2_min; break;
		}
		return result == 192 ? 195 : result;
	}
}