package medium.Search_in_Rotated_Sorted_Array;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		//int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
		int[] nums = new int[]{6, 7, 8, 1, 2, 3, 4, 5};
		for(int i = 0; i< nums.length; i++) {
			PerformanceUtil.calcPerformance(new Solution(), nums, 9);
		}
	}
}
