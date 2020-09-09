package medium.Largest_Divisible_Subset;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 181ms(5.01%)
 * Memory : 78mb(5.01%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,2,4,8};
		List<Integer> resultList = largestDivisibleSubset(nums);
		for(int num : resultList) {
			System.out.print(num + ", ");
		}
	}
	private List<Integer> recursion(int curIdx, int divIdx, int[] nums, List<Integer>[][] record) {
		if(curIdx == nums.length) return new LinkedList<>();
		else if(divIdx != -1 && record[curIdx][divIdx] != null) return new LinkedList<>(record[curIdx][divIdx]);

		List<Integer> list = recursion(curIdx + 1, divIdx, nums, record);
		if(nums[curIdx] % (divIdx == -1 ? 1 : nums[divIdx]) == 0) {
			List<Integer> updatedList = recursion(curIdx + 1, curIdx, nums, record);
			updatedList.add(nums[curIdx]);
			list = list.size() < updatedList.size() ? updatedList : list;
		}

		if(divIdx != -1) record[curIdx][divIdx] = list;
		return new LinkedList<>(list);
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums == null || nums.length == 0) return Collections.emptyList();
		else if(nums.length == 1) return Arrays.asList(nums[0]);

		Arrays.sort(nums);
		List<Integer>[][] record = new LinkedList[nums.length][nums.length];
		return recursion(0, -1, nums, record);
	}
}
