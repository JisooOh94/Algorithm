package medium.Combination_Sum_2;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int targetNum = 5;
		int[] candidates = new int[]{2,5,2,1,2};
		PerformanceUtil.calcPerformance(new Solution(), candidates, targetNum);
	}
}
