package LeetCode.Analyze_User_Website_Visit_Pattern;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		String[] userNameList = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
//		String[] webSiteList = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};
//		int[] timeStampList = new int[]{1,2,3,4,5,6,7,8,9,10};

		String[] userNameList = new String[]{"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
		String[] webSiteList = new String[]{"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
		int[] timeStampList = new int[]{436363475,710406388,386655081,797150921};

		PerformanceUtil.calcPerformance(new Solution(), userNameList, timeStampList, webSiteList);
	}
}
