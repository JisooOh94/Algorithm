package LeetCode.AddTwoNumbers;

public class Solution {
	public static LeetCode.AddTwoNumbers.ListNode addTwoNumbers(LeetCode.AddTwoNumbers.ListNode l1, LeetCode.AddTwoNumbers.ListNode l2) {
		LeetCode.AddTwoNumbers.ListNode node_1 = l1;
		LeetCode.AddTwoNumbers.ListNode node_2 = l2;
		LeetCode.AddTwoNumbers.ListNode result = null;
		LeetCode.AddTwoNumbers.ListNode cur = null;

		int upperNum = 0;

		while(true) {
			if(node_1 == null && node_2 == null) {
				if(upperNum != 0) {
					cur.next = new LeetCode.AddTwoNumbers.ListNode(upperNum);
				}
				break;
			} else if(node_1 == null) {
				while(node_2 != null) {
					int sum = node_2.val + upperNum;
					int num = sum % 10;
					upperNum = sum / 10;
					cur.next = new LeetCode.AddTwoNumbers.ListNode(num);
					cur = cur.next;
					node_2 = node_2.next;
				}
				if(upperNum != 0) {
					cur.next = new LeetCode.AddTwoNumbers.ListNode(upperNum);
				}
				break;
			} else if(node_2 == null) {
				while(node_1 != null) {
					int sum = node_1.val + upperNum;
					int num = sum % 10;
					upperNum = sum / 10;
					cur.next = new LeetCode.AddTwoNumbers.ListNode(num);
					cur = cur.next;
					node_1 = node_1.next;
				}
				if(upperNum != 0) {
					cur.next = new LeetCode.AddTwoNumbers.ListNode(upperNum);
				}
				break;
			}

			int sum = node_1.val + node_2.val + upperNum;
			int num = sum % 10;
			upperNum = sum / 10;

			if(result == null) {
				result = new LeetCode.AddTwoNumbers.ListNode(num);
				cur = result;
			} else {
				cur.next = new LeetCode.AddTwoNumbers.ListNode(num);
				cur = cur.next;
			}

			node_1 = node_1.next;
			node_2 = node_2.next;
		}

		return result;
	}
}
