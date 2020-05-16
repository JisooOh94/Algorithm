package Find_First_and_Last_Position_of_Element;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[] nums = new int[]{6, 8, 9};
		int target = 6;
		PerformanceUtil.calcPerformance(new Solution(), nums, target);
	}
}
