package medium.Maximum_Product_Subarray;

import org.junit.Test;

/**
 * Runtime : 2ms(35.96%)
 * Memory : 39.6mb(47.96%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{2, 3, -2, 4};
//		int[] nums = new int[]{-2, 0, -1};
		System.out.println(maxProduct(nums));
	}
	public int maxProduct(int[] nums) {
		int minusCnt = 0;
		int maxMult = -999999;
		Integer reMult, allMult;
		reMult = allMult = null;

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				maxMult = Math.max(maxMult, allMult == null ? 0 : reMult == null ? Math.max(allMult, 0) : Math.max(allMult, Math.max(reMult, 0)));
				minusCnt = 0;
				allMult = reMult = null;
			} else if(nums[i] < 0) {
				if(minusCnt == 0) {
					maxMult = allMult == null ? maxMult : Math.max(maxMult, allMult);
					allMult = allMult == null ? nums[i] : allMult * nums[i];
				} else {
					maxMult = Math.max(maxMult, allMult);
					allMult *= nums[i];
					reMult = reMult == null ? nums[i] : reMult * nums[i];
				}
				minusCnt++;
			} else {
				allMult = allMult == null ? nums[i] : allMult * nums[i];
				reMult = minusCnt >= 1 ? reMult == null ? nums[i] : reMult * nums[i] : null;
			}
		}

		maxMult = Math.max(maxMult, allMult == null ? maxMult : reMult == null ? allMult : Math.max(allMult, reMult));
		return maxMult;
	}
}
