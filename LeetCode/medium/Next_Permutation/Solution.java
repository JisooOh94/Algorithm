package medium.Next_Permutation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.Predicate;

/**
 * Runtime : 1ms(35.60)
 * Memory : 39.2mb(50.00)
 */
public class Solution implements Predicate<List<Integer>, Object> {
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

		int breaker = -1, switcher = -1;
		for (int i = nums.length - 1; 0 < i; i--) {
			if (nums[i - 1] < nums[i]) {
				breaker = i - 1;
				break;
			}
		}

		if (breaker != -1) {
			int front = breaker + 1;
			int back = nums.length - 1;
			switcher = back;

			while (front <= back) {
				swap(nums, front, back);

				if (nums[breaker] < nums[front]) {
					if(nums[front] < nums[switcher] || (nums[front] == nums[switcher] && front < switcher)) {
						switcher = front;
					}
				}

				if (nums[breaker] < nums[back]) {
					if(nums[back] < nums[switcher] || (nums[back] == nums[switcher] && back < switcher)) {
						switcher = back;
					}
				}

				front++;
				back--;
			}

			swap(nums, breaker, switcher);
		} else {
			Arrays.sort(nums);
		}

		return nums;
	}

	private void nextPermutation_(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return;
		} else if(nums.length == 2) {
			swap(nums, 0, 1);
			return;
		}

		int breaker = -1, switcher = -1;
		for (int i = nums.length - 1; 0 < i; i--) {
			if (nums[i - 1] < nums[i]) {
				breaker = i - 1;
				break;
			}
		}

		if (breaker != -1) {
			int front = breaker + 1;
			int back = nums.length - 1;
			switcher = back;

			while (front < back) {
				swap(nums, front, back);

				if (nums[front] < nums[switcher] && nums[breaker] < nums[front]) {
					switcher = front;
				}

				if (nums[back] < nums[switcher] && nums[breaker] < nums[back]) {
					switcher = back;
				}

				front++;
				back--;
			}

			swap(nums, breaker, switcher);
		} else {
			Arrays.sort(nums);
		}
	}

	private void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}
}
