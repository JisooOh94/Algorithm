package medium.Rotting_Oranges;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {

	@Test
	public void test() {
//		int[][] grid = new int[][]{
//				{2,1,1},
//				{1,1,0},
//				{0,1,1},
//		};

//		int[][] grid = new int[][]{
//				{2,1,1},
//				{0,1,1},
//				{1,0,1}
//		};

		int[][] grid = new int[][]{
				{0,2}
		};

		PerformanceUtil.calcPerformance(new Solution(), (Object) grid);
	}
}
