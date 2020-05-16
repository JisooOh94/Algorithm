package Next_Permutation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.Predicate;

public class Solution_2 implements Predicate<List<Integer>, Object> {
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
			int front = breaker + 1;
			int back = nums.length - 1;

			while (front < back) {
				swap(nums, front, back);

				front++;
				back--;
			}

			for(int i = breaker + 1; i < nums.length; i++) {
				if(nums[breaker] < nums[i]) {
					swap(nums, breaker, i);
					break;
				}
			}
		} else {
			Arrays.sort(nums);
		}

		return nums;
	}

	private void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}
}
