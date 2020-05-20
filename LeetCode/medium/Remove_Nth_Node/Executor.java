package medium.Remove_Nth_Node;

import org.junit.Test;
import util.ListNode;
import util.PerformanceUtil;

public class Executor {
	private ListNode makeList(int... params) {
		ListNode head = new ListNode(params[0]);
		ListNode cur = head;
		for(int i = 1; i < params.length; i++) {
			cur.next = new ListNode(params[i]);
			cur = cur.next;
		}

		return head;
	}
	@Test
	public void test() {
		PerformanceUtil.calcPerformance(new BestSolution(), makeList(1,2,3,4,5,6), 4);
	}
}
