package medium.Jump_Game_II;

/**
 * Runtime : 2ms(63.63%)
 * Memory : 46.3mb(19.36%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int jump(int[] nums) {
		if(nums.length == 1) return 0;
		int target = 0;
		int nextTarget = nums[0];
		int jumpCnt = 0;
		while(nextTarget < nums.length - 1) {
			int maxTarget = 0;
			while(target <= nextTarget) {
				maxTarget = Math.max(maxTarget, target + nums[target]);
				target++;
			}
			target = nextTarget + 1;
			nextTarget = maxTarget;
			jumpCnt++;
		}
		return jumpCnt + 1;
	}
}
