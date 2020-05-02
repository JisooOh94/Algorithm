package LeetCode.Number_of_Islands;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		char[][] grid = new char[][]{
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};

//		char[][] grid = new char[][]{
//				{'1', '1'}
//		};

		PerformanceUtil.calcPerformance(new Solution(), (Object) grid);
	}
}
