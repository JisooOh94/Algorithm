package Next_Permutation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.Predicate;

/**
 * Runtime : 0ms(100.0%)
 * Memory : 39.3mb(50.00%)
 */
public class Solution_4 implements Predicate<List<Integer>, Object> {
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
			for(int i = breaker + 1; i < nums.length; i++) {
				if(nums[i] <= nums[breaker]) {
					swap(nums, breaker, i - 1);
					break;
				} else if(i == nums.length - 1) {
					swap(nums,breaker, i);
				}
			}
			reverse(nums, breaker + 1, nums.length - 1);
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
