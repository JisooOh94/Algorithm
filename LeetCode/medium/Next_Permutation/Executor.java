package medium.Next_Permutation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		List<Integer> list = IntStream.range(1, 100000).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		//int[] nums = list.stream().mapToInt(i -> i).toArray();
		//int[] nums = new int[]{2,2,7,5,4,3,2,2,1};
		int[] nums = new int[]{1,2,3};

		System.out.println("# Solution 1 - ");
		PerformanceUtil.calcPerformance(new Solution(), nums.clone());
		System.out.println("# Solution 2 - ");
		PerformanceUtil.calcPerformance(new Solution_2(), nums.clone());
		System.out.println("# Solution 3 - ");
		PerformanceUtil.calcPerformance(new Solution_3(), nums.clone());
		System.out.println("# Solution 4 - ");
		PerformanceUtil.calcPerformance(new Solution_4(), nums.clone());
	}
}
