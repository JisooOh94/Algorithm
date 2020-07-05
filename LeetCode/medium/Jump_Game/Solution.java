package medium.Jump_Game;

import org.junit.Test;

/**
 * Runtime : 1ms(99.09%)
 * Memory : 42.1mb(27.00%)
 */
public class Solution {
	@Test
	public void test() {
//		int[] nums = new int[]{2,3,1,1,4};
//		int[] nums = new int[]{3,2,1,0,4};
//		int[] nums = new int[]{0, 1};
		int[] nums = new int[]{1,1,1,0};
		System.out.println(canJump(nums));
	}

	public boolean canJump(int[] nums) {
		int fromIdx = 0;
		int toIdx = nums[0];
		while(true) {
			if(nums.length - 1 <= toIdx) {
				return true;
			}

			int maxRange = -1;
			for(int i = fromIdx + 1; i <= toIdx; i++) {
				if(maxRange < i + nums[i]) {
					maxRange = i + nums[i];
				}
			}

			if(maxRange <= toIdx) break;

			fromIdx = toIdx;
			toIdx = maxRange;
		}

		return false;
	}
}
