package medium.Permutations;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[] samples = new int[]{1,2,3,4};
		PerformanceUtil.calcPerformance(new Solution(), samples);
	}
}
