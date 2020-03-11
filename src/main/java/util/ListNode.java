package util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static ListNode makeList(int... args) {
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
}
