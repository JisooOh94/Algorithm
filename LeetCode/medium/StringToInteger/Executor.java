package medium.StringToInteger;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		String input = "";

		PerformanceUtil.calcPerformance(new Solution(), (Object)input);
	}
}
