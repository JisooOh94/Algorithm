package K_Closest_Points_to_Origin;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[][] points = new int[][]{
				{3, 3},
				{5, -1},
				{-2, 4}
		};
		int k = 2;
		PerformanceUtil.calcPerformance(new Solution_3(), (Object) points, k);
	}
}
