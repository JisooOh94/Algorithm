package Generate_Parentheses;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int n = 3;
		PerformanceUtil.calcPerformance(new Solution(), n);
	}
}
