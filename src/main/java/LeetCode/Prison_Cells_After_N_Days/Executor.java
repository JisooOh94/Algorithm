package LeetCode.Prison_Cells_After_N_Days;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		int[] cells = new int[]{0,1,0,1,1,0,0,1};
//		int N = 7;
		int[] cells = new int[]{1,0,0,1,0,0,1,0};
		int N = 1000000000;
		PerformanceUtil.calcPerformance(new Solution(), (Object)cells, N);
	}
}
