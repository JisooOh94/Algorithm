package medium.Reduction_Operations_to_Make_the_Array_Elements_Equal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 41ms(50.00%)
 * Memory : 48.9mb(25.00%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution_3 {
	@Test
	public void execute() {
		int[] nums = new int[]{1,1,2,2,3};
		System.out.println(reductionOperations(nums));
	}
	public int reductionOperations(int[] nums) {
		Arrays.sort(nums);
		int cur = nums[0];
		int gapCnt = 0;
		int operationCnt = 0;

		for(int num : nums) {
			if(num == nums[0]) continue;
			else if(num != cur) {
				cur = num;
				gapCnt++;
			}

			operationCnt += gapCnt;
		}
		return operationCnt;
	}
}
