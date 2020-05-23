package easy.Minimum_Subsequence_in_Non_Increasing_Order;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[] nums = new int[]{4,3,10,9,8};
		PerformanceUtil.calcPerformance(new Solution(), (Object) nums);
	}
}
