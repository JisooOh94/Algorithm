package LeetCode.Meeting_Rooms_II;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		int[][] timeArr = new int[][]{
//				{0, 30},
//				{5, 10},
//				{15, 20},
//		};

//		int[][] timeArr = new int[][]{
//				{7, 10},
//				{2, 4}
//		};

		int[][] timeArr = new int[][]{
				{5,8},
				{6,8}
		};
		PerformanceUtil.calcPerformance(new Solution_3(), (Object) timeArr);
	}
}
