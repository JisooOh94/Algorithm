package LeetCode.AddTwoNumbers;

import util.PerformanceUtil;

public class Executor {
	private static ListNode makeList(int... args) {
		ListNode head = null;
		ListNode cur = null;

		for(int value : args) {
			if(head == null) {
				head = new ListNode(value);
				cur = head;
			} else {
				cur.next = new ListNode(value);
				cur = cur.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node_1 = makeList(2,4,3);
		ListNode node_2 = makeList(5,6,4);

		PerformanceUtil.calcPerformance(new Solution(), node_1, node_2);
	}
}
