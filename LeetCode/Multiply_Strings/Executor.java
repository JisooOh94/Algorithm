package Multiply_Strings;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		long num1_int = 1235678;
		long num2_int = 987654;
		String num1 = "9133";
		String num2 = "0";
		PerformanceUtil.calcPerformance(new Solution(), num1, num2);

		System.out.println("# Actual Result : " + num1_int * num2_int);
	}
}
