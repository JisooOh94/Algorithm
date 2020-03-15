package LeetCode.Next_Permutation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;
import util.Predicate;

/**
 * Runtime : 1ms(35.60%)
 * Memory : 391.mb(50.00%)
 */
public class Solution_3 implements Predicate<List<Integer>, Object> {
	public List<Integer> test(Object... params) {
		return IntStream.of(nextPermutation((int[])params[0])) // return Intstream
				.boxed()        // Stream<Integer>
				.collect(Collectors.toList());
	}

	private int[] nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return nums;
		} else if(nums.length == 2) {
			swap(nums, 0, 1);
			return nums;
		}

		int breaker = -1;
		for (int i = nums.length - 1; 0 < i; i--) {
			if (nums[i - 1] < nums[i]) {
				breaker = i - 1;
				break;
			}
		}

		if (breaker != -1) {
			reverse(nums, breaker + 1, nums.length - 1);

			int switcher = Arrays.binarySearch(nums, breaker + 1, nums.length, nums[breaker]);
			if(switcher < 0) {
				switcher = switcher * -1 - 1;
			} else {
				while(nums[switcher] == nums[++switcher]) { }
			}
			swap(nums, breaker, switcher);
		} else {
			reverse(nums, 0, nums.length - 1);
		}

		return nums;
	}

	private void reverse(int[] nums, int from, int to) {
		while(from < to) {
			swap(nums, from, to);
			from++;
			to--;
		}
	}

	private void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}
}
