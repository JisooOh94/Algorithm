package medium.Continuous_Subarray_Sum;

/**
 * Runtime : 19ms(13.14%)
 * Memory : 52.5mb(5.05%)
 */
public class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length == 0) return false;
		if(k == 0) {
			int prev = nums[0];
			for(int i = 1; i < nums.length; i++) {
				if(nums[i] == 0 && prev == 0) return true;
				prev = nums[i];
			}
			return false;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			int sum = nums[i];
			for(int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if(sum % k == 0) return true;
			}
		}
		return false;
	}
}
