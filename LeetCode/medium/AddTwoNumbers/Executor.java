package medium.AddTwoNumbers;

import util.ListNode;
import util.PerformanceUtil;

public class Executor {
	public static void main(String[] args) {
		ListNode node_1 = ListNode.makeList(2,4,3);
		ListNode node_2 = ListNode.makeList(5,6,4);

		PerformanceUtil.calcPerformance(new Solution(), node_1, node_2);
	}
}
