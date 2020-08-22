package medium.Greatest_Sum_Divisible_by_Three;

import org.junit.Test;

/**
 * Runtiem : 16ms(23.61%)
 * Memory : 45.5mb(51.98%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{1,2,3,4,4};
//		int[] nums = new int[]{3,6,5,1,8};
//		int[] nums = new int[]{5,2,2,2};
		System.out.println(maxSumDivThree(nums));
	}

	public int maxSumDivThree(int[] nums) {
		int[] record = new int[3];
		record[0] = 0;
		record[1] = -1;
		record[2] = -1;

		for(int i = 0; i < nums.length; i++) {
			int left0, left1, left2;
			left0 = left1 = left2 = -1;
			if(nums[i] % 3 == 0) {
				left0 = record[0] + nums[i];
				if(record[1] != -1)left1 = record[1] + nums[i];
				if(record[2] != -1)left2 = record[2] + nums[i];
			} else if(nums[i] % 3 == 1) {
				if(record[2] != -1) left0 = record[2] + nums[i];
				if(record[0] != -1)left1 = record[0] + nums[i];
				if(record[1] != -1)left2 = record[1] + nums[i];
			} else if(nums[i] % 3 == 2) {
				if(record[1] != -1) left0 = record[1] + nums[i];
				if(record[2] != -1)left1 = record[2] + nums[i];
				if(record[0] != -1)left2 = record[0] + nums[i];
			}
			record[0] = Math.max(record[0], left0);
			record[1] = Math.max(record[1], left1);
			record[2] = Math.max(record[2], left2);
		}
		return record[0];
	}
}
