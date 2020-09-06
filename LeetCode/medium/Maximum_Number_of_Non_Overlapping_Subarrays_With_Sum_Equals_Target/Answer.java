package medium.Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;
import util.PerformanceUtil;

public class Answer {
	@Test
	public void execute() {
		int[] nums = new int[]{-1,3,5,1,4,2,-9}; int target = 6;
//		int[] nums = new int[]{-2,6,6,3,5,4,1,2,8}; int target = 10;
//		int[] nums = new int[]{0,0,0}; int target = 0;
		PerformanceUtil.beforeTest();
		System.out.println(maxNonOverlapping(nums, target));
		System.out.println(PerformanceUtil.afterTest());
	}
	public int maxNonOverlapping(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);

		int sum = 0;
		int maxCnt = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - target)) {
				maxCnt = Math.max(maxCnt, map.get(sum - target) + 1);
			}
			map.put(sum, maxCnt);
		}

		return maxCnt;
	}
}
