package LeetCode.Spiral_Matrix;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[][] matrix = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};

		int[][] matrix2 = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};

		int[][] matrix3 = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		int[][] matrix4 = new int[][]{
				{1,2,3},
				{4,5,6}
		};

		PerformanceUtil.calcPerformance(new Solution(), (Object)matrix4);
	}
}
