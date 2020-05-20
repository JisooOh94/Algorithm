package medium.Longest_Palindromic_Substring;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void testSolution() {
		String input = "abcba";

		PerformanceUtil.calcPerformance(new Solution(), (Object)input);
	}
}
