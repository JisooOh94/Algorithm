package Minimum_Cost_to_Connect_Sticks;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		//int[] sticks = new int[]{2,4,3};
		int[] sticks = new int[]{1, 8, 3, 5};
		PerformanceUtil.calcPerformance(new Solution_2(), (Object)sticks);
	}
}
