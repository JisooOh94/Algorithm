package LeetCode.Swap_Nodes_in_Pairs;

import org.junit.Test;
import util.ListNode;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		ListNode head = ListNode.makeList(1, 2);
		PerformanceUtil.calcPerformance(new Solution(), head);
	}
}
