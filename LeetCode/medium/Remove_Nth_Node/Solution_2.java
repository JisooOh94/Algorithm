package medium.Remove_Nth_Node;

import java.util.LinkedList;
import java.util.List;

import util.ListNode;
import util.Predicate;

/**
 * Runtime : 16ms (14.24%)
 * Memory : 40.7 mb (6.37%)
 */
public class Solution_2 implements Predicate<List, Object> {
	public List test(Object[] params ) {
		List<Integer> resultList = new LinkedList();
		ListNode head = removeNthFromEnd((ListNode)params[0], (int)params[1]);
		ListNode cur = head;
		while(cur != null) {
			resultList.add(cur.val);
			cur = cur.next;
		}

		return resultList;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) {
			return null;
		} else if(n == 0) {
			return head;
		}

		ListNode cur = head;
		if(n == 1) {
			ListNode prev = cur;
			while(cur.next != null) {
				prev = cur;
				cur = cur.next;
			}
			prev.next = null;
			return head;
		}

		int initialSize = 1000000;
		ListNode[] nodeArr = new ListNode[initialSize];
		int nodeCnt = 0;

		while(cur != null) {
			nodeArr[nodeCnt++] = cur;
			if(nodeCnt == nodeArr.length) {
				ListNode[] newArr = new ListNode[nodeCnt + initialSize];
				System.arraycopy(nodeArr, 0, newArr, 0, nodeCnt);
				nodeArr = newArr;
			}

			cur = cur.next;
		}

		int targetIdx = nodeCnt - n;

		if(targetIdx == 0) {
			head = head.next;
		} else if(targetIdx == nodeCnt - 1) {
			nodeArr[targetIdx - 1].next = null;
		} else {
			nodeArr[targetIdx - 1].next = nodeArr[targetIdx + 1];
		}

		return head;
	}
}
