package medium.Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import util.PerformanceUtil;

public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{2,2,1,1,2,1,2,1,1,2,2,1,1,2,1,2,2,2,2,1,2,2,2,1,1,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,2,2,1,2,1,2,1,1,1,2,1,1,1,2,2,2,1,1,1,2,1,2,2,2,2,2,2,2,1,2,1,1,2,2,2,2,1,2,1,1,1,2,2,2,1,1,2,1,2,1,1,1,2,2,1,1,2,1,2,1,2,2,1,1,2,2,1,2,2,1,2,1,1,2,2,2,2,1,1,2,1,1,1,2,1,2,2,1,1,2,2,2,2,1,2,1,2,2,2,2,1,2,2,1,1,1,1,2,2,1,1,1,1,1,2,2,2,1,1,1,2,2,1,2,2,2,2,2,2,2,1,2,2,1,2,1,2,1,2,1,2,2,2,2,2,1,1,1,1,2,2,1,2,2,2,2,2,2,1,2,2,1,1,2,1,1,2,2,1,1,2,2,1,2,1,2,1,1,2,1,2,2,1,2,2,1,1,1,2,2,2,2,2,2,2,1,1,1,1,1,2,1,1,2,1,1,2,2,1,2,1,1,1,1,2,1,1,2,1,2,2,1,2,2,2,2,1,2,1,2,1,1,1,1,1,1,2,1,1,1,2,2,1}; int target = 2000;
//		int[] nums = new int[]{-2,6,6,3,5,4,1,2,8}; int target = 10;
//		int[] nums = new int[]{0,0,0}; int target = 0;
		PerformanceUtil.beforeTest();
		System.out.println(maxNonOverlapping(nums, target));
		System.out.println(PerformanceUtil.afterTest());
	}
	public int maxNonOverlapping(int[] nums, int target) {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;

		for(int i = 0; i < nums.length; i++) {
			queue.offer(0);
			int size = queue.size();
			for(int j = 0; j < size; j++) {
				int curSum = queue.poll();

				if(curSum + nums[i] == target) {
					cnt++;
					queue.clear();
					break;
				} else {
					queue.offer(curSum + nums[i]);
				}
			}
		}

		return cnt;
	}
}
