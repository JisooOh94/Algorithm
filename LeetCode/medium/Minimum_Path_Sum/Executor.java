package medium.Minimum_Path_Sum;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[][] grid = new int[][]{
				{1, 3, 1, 2},
				{1, 5, 1, 2},
				{4, 2, 1, 2}
		};

		int[][] grid_2 = new int[][]{
				{0}
		};
		PerformanceUtil.calcPerformance(new Solution_2(), (Object)grid);
	}
}
