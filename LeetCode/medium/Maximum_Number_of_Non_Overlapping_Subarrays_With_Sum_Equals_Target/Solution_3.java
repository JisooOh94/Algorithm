package medium.Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;
import util.PerformanceUtil;

public class Solution_3 {
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
		List<int[]> list = new LinkedList<>();
		int cnt = 0;

		for(int i = 0; i < nums.length; i++) {
			list.add(new int[]{0});
			for(Iterator<int[]> iter = list.iterator(); iter.hasNext();){
				int[] curSum = iter.next();
				curSum[0] += nums[i];
				if(curSum[0] == target) {
					cnt++;
					list.clear();
					list.add(new int[]{0});
				}
			}
		}

		return cnt;
	}
}
