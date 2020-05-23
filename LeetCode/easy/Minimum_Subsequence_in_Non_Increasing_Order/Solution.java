package easy.Minimum_Subsequence_in_Non_Increasing_Order;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;

/**
 * Runtime : 5ms(48.91%)
 * Memory : 39.8mb(100.00%)
 */
public class Solution implements Predicate<List, Object> {
	@Override
	public List<Integer> test(Object... params) {
		return minSubsequence((int[])params[0]);
	}
	public List<Integer> minSubsequence(int[] nums) {
		if(nums.length == 1) return Arrays.asList(nums[0]);

		Arrays.sort(nums);
		int sum = Arrays.stream(nums).sum();

		List<Integer> resultList = new LinkedList<>();

		int sequeceSum = 0;
		for(int i = nums.length - 1; 0 <= i; i--) {
			sequeceSum += nums[i];
			sum -= nums[i];
			resultList.add(nums[i]);

			if(sequeceSum > sum) break;
		}

		return resultList;
	}
}
