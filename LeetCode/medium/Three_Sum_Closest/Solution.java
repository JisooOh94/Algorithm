package medium.Three_Sum_Closest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import util.Predicate;

public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return threeSum((int[]) params[0], (int) params[1]);
	}

	public static int threeSum(int[] nums, int target) {
		Arrays.sort(nums);

		int minGap = 99999;
		int resultSum = 0;

		Set<Integer> firstVisited = new HashSet<Integer>();

		for(int x = 0; x < nums.length - 2; x++) {
			if(firstVisited.contains(nums[x])) continue;

			Set<Integer> secondVisited = new HashSet<Integer>();

			for(int y = x + 1; y < nums.length - 1; y++) {
				if(firstVisited.contains(nums[y]) || secondVisited.contains(nums[y])) continue;

				int targetNum = target - (nums[x] + nums[y]);

				if(firstVisited.contains(targetNum) || secondVisited.contains(targetNum)) continue;

				int fromIdx = y + 1;

				int findResult = Arrays.binarySearch(nums, fromIdx, nums.length, targetNum);

				if(findResult >= 0) {
					return nums[x] + nums[y] + targetNum;
				}

				if((findResult * -1) -1  > fromIdx) {
					int min = (findResult * -1) - 2;
					int max = (findResult * -1) - 1;

					if (0 <= min && getGap(nums[x], nums[y], nums[min], target) < minGap) {
						minGap = getGap(nums[x], nums[y], nums[min], target);
						resultSum = nums[x] + nums[y] + nums[min];
					}

					if (max < nums.length && getGap(nums[x], nums[y], nums[max], target) < minGap) {
						minGap = getGap(nums[x], nums[y], nums[max], target);
						resultSum = nums[x] + nums[y] + nums[max];
					}
				} else if((findResult * -1) -1  == fromIdx) {
					int max = (findResult * -1) - 1;

					if (max < nums.length && getGap(nums[x], nums[y], nums[max], target) < minGap) {
						minGap = getGap(nums[x], nums[y], nums[max], target);
						resultSum = nums[x] + nums[y] + nums[max];
					}
				}

				secondVisited.add(nums[y]);
			}
			firstVisited.add(nums[x]);
		}

		return resultSum;
	}

	private static int getGap(int num1, int num2, int num3, int target) {
		return Math.abs(target - (num1 + num2 + num3));
	}
}
