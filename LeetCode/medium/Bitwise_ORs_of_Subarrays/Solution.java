package medium.Bitwise_ORs_of_Subarrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * Runtime : 360ms (94.74%)
 * Memory : 179mb (37.85%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,1,2};
//		int[] nums = new int[]{1,2,4};
		System.out.println(subarrayBitwiseORs(nums));
	}
	public int subarrayBitwiseORs(int[] nums) {
		Set<Integer> uniqueSet = new HashSet<>();
		Set<Integer>[] record = new HashSet[nums.length];

		record[0] = new HashSet<>();
		record[0].add(nums[0]);
		uniqueSet.add(nums[0]);
		for(int i = 1; i < nums.length; i++) {
			record[i] = new HashSet<>();
			for(Iterator<Integer> iter = record[i - 1].iterator(); iter.hasNext();) {
				int bitWiseVal = iter.next() | nums[i];
				record[i].add(bitWiseVal);
				uniqueSet.add(bitWiseVal);
			}
			record[i].add(nums[i]);
			uniqueSet.add(nums[i]);
		}

		return uniqueSet.size();
	}
}