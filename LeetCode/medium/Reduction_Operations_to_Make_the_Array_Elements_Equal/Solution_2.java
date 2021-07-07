package medium.Reduction_Operations_to_Make_the_Array_Elements_Equal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 61ms(50.00%)
 * Memory : 113.4mb(25.00%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{1,1,2,2,3};
		System.out.println(reductionOperations(nums));
	}
	public int reductionOperations(int[] nums) {
		Arrays.sort(nums);
		List<Integer> cntList = new ArrayList<>();
		int cur = nums[0];
		int curCnt = 0;

		for(int num : nums) {
			if(num != cur) {
				cntList.add(curCnt);
				cur = num;
				curCnt = 1;
			} else {
				curCnt++;
			}
		}
		cntList.add(curCnt);

		int operationCnt = 0;
		for(int i = 1; i < cntList.size(); i++) {
			operationCnt += cntList.get(i) * i;
		}
		return operationCnt;
	}
}
