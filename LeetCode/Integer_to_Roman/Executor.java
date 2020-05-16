package Integer_to_Roman;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		Integer input = 3999;
		PerformanceUtil.calcPerformance(new Solution(), (Object) input);
	}
}
