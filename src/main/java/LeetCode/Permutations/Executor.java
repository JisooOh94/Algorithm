package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		int[] samples = new int[]{1,2,3,4};
		PerformanceUtil.calcPerformance(new Solution(), samples);
	}
}
