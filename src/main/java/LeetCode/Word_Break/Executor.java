package LeetCode.Word_Break;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import util.Node;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		String source = "applepenapple";
//		List<String> wordDict = Arrays.asList("apple", "pen");
//		String source = "leetcode";
//		List<String> wordDict = Arrays.asList("leet", "cod");
		String source = "catsandog";
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

		PerformanceUtil.calcPerformance(new Solution(), source, wordDict);

	}
}
