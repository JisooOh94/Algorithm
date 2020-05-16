package LeetCode.Search_Suggestions_System;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
//		String searchWord = "mouse";
//		String[] products = new String[]{"havana"};
//		String searchWord = "havana";
		String[] products = new String[]{"bags","baggage","banner","box","cloths"};
		String searchWord = "bags";
		PerformanceUtil.calcPerformance(new Solution(), products, searchWord);
	}
}
