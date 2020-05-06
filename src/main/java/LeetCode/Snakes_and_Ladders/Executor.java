package LeetCode.Snakes_and_Ladders;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		int[][] board = new int[][]{
//				{-1,-1,-1,-1,-1,-1},
//				{-1,-1,-1,-1,-1,-1},
//				{-1,-1,-1,-1,-1,-1},
//				{-1,35,-1,-1,13,-1},
//				{-1,-1,-1,-1,-1,-1},
//				{-1,15,-1,-1,-1,-1}
//		};

//		int[][] board = new int[][]{
//				{-1, -1, -1},
//				{-1, 9, 8},
//				{-1, 8, 9}
//		};

//		int[][] board = new int[][]{
//				{1, 1, -1},
//				{1, 1, 1},
//				{-1, 1, 1}
//		};

		int[][] board = new int[][]{
				{-1, -1, -1, 46, 47, -1, -1, -1},
				{51, -1, -1, 63, -1, 31, 21, -1},
				{-1, -1, 26, -1, -1, 38, -1, -1},
				{-1, -1, 11, -1, 14, 23, 56, 57},
				{11, -1, -1, -1, 49, 36, -1, 48},
				{-1, -1, -1, 33, 56, -1, 57, 21},
				{-1, -1, -1, -1, -1, -1, 2, -1},
				{-1, -1, -1, 8, 3, -1, 6, 56}
		};

		PerformanceUtil.calcPerformance(new Solution(), (Object) board);
	}
}
