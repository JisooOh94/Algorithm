package LeetCode.FourSum;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {

	@Test
	public void test() {
		//int nums[] = new int[]{1, 0, -1, 0, -2, 2};
		int nums[] = new int[]{-1};
		int target = 0;

		PerformanceUtil.calcPerformance(new Solution(), nums, target);
	}
}
