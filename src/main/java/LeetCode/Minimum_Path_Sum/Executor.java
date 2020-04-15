package LeetCode.Minimum_Path_Sum;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import LeetCode.Group_Anagrams.Solution2;
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
