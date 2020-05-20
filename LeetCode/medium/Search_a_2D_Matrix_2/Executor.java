package medium.Search_a_2D_Matrix_2;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		int[][] matrix = new int[][]{
//				{1, 4, 7, 11, 15},
//				{2, 5, 8, 12, 19},
//				{3, 6, 9, 16, 22},
//				{10, 13, 14, 17, 24},
//				{18, 21, 23, 26, 30}
//		};
//		int target = 4;
		int [][] matrix = new int[][] {
				{1,4},
				{2,5}
		};
		int target = 5;
		PerformanceUtil.calcPerformance(new Solution(), matrix, target);
	}
}
