package medium.Course_Schedule_2;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		int numCourses = 4; int[][] pres = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		int numCourses = 2; int[][] pres = new int[][]{{0, 1}, {1, 0}};
		PerformanceUtil.calcPerformance(new Solution_2(), numCourses, pres);
	}
}
