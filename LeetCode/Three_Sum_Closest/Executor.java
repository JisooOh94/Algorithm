package Three_Sum_Closest;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	//int nums[] = new int[]{-1, 2, 1, -4};
	int nums[] = new int[]{0,2,1};
	int targetNum = 1;
	@Test
	public void test() {
		PerformanceUtil.calcPerformance(new Solution(), new Object[]{nums, targetNum});
	}
}
