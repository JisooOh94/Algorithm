package LeetCode.Group_Anagrams;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		String[] samples = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		//String[] samples = new String[]{"abc"};
		PerformanceUtil.calcPerformance(new Solution4(), (Object)samples);
	}
}
