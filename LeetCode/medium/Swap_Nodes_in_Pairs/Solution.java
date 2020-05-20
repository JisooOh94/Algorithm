package medium.Swap_Nodes_in_Pairs;

import java.util.LinkedList;
import java.util.List;

import util.ListNode;
import util.Predicate;

/**
 * Runtime : 0ms(100%)
 * Memory : 37.4mb(5.5%)
 */
public class Solution implements Predicate<List<Integer>, Object> {
	public List<Integer> test(Object... params) {
		ListNode head = swapPairs((ListNode) params[0]);
		List<Integer> resultList = new LinkedList<>();
		while(head != null) {
			resultList.add(head.val);
			head = head.next;
		}

		return resultList;
	}

	private ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode prev = cur;
		ListNode temp;
		head = head.next;

		while(cur!= null && cur.next != null) {
			prev.next = cur.next;
			prev = cur;

			temp = cur.next;
			cur.next = temp.next;
			temp.next = cur;
			cur = cur.next;
		}

		return head;
	}
}
