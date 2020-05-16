package Path_With_Maximum_Minimum_Value;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[][] board = new int[][]{
				{3,4,6,3,4},
				{0,2,1,1,7},
				{8,8,3,2,7},
				{3,2,4,9,8},
				{4,1,2,0,0},
				{4,6,5,4,3}
		};

		PerformanceUtil.calcPerformance(new Solution(), (Object) board);
	}
}
