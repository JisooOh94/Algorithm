package LeetCode.AddTwoNumbers;

import util.ListNode;
import util.Predicate;

public class Solution implements Predicate<String, Object> {

	public String test(Object... params) {
		ListNode result = addTwoNumbers((ListNode)params[0], (ListNode)params[1]);
		ListNode cur = result;
		String resultStr = "";
		while(cur != null) {
			resultStr += cur.val + " > ";
			cur = cur.next;
		}

		return resultStr;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node_1 = l1;
		ListNode node_2 = l2;
		ListNode result = null;
		ListNode cur = null;

		int upperNum = 0;

		while(true) {
			if(node_1 == null && node_2 == null) {
				if(upperNum != 0) {
					cur.next = new ListNode(upperNum);
				}
				break;
			} else if(node_1 == null) {
				while(node_2 != null) {
					int sum = node_2.val + upperNum;
					int num = sum % 10;
					upperNum = sum / 10;
					cur.next = new ListNode(num);
					cur = cur.next;
					node_2 = node_2.next;
				}
				if(upperNum != 0) {
					cur.next = new ListNode(upperNum);
				}
				break;
			} else if(node_2 == null) {
				while(node_1 != null) {
					int sum = node_1.val + upperNum;
					int num = sum % 10;
					upperNum = sum / 10;
					cur.next = new ListNode(num);
					cur = cur.next;
					node_1 = node_1.next;
				}
				if(upperNum != 0) {
					cur.next = new ListNode(upperNum);
				}
				break;
			}

			int sum = node_1.val + node_2.val + upperNum;
			int num = sum % 10;
			upperNum = sum / 10;

			if(result == null) {
				result = new ListNode(num);
				cur = result;
			} else {
				cur.next = new ListNode(num);
				cur = cur.next;
			}

			node_1 = node_1.next;
			node_2 = node_2.next;
		}

		return result;
	}
}
