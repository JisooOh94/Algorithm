package Remove_Nth_Node;

import java.util.LinkedList;
import java.util.List;

import util.ListNode;
import util.Predicate;

/**
 * Runtime : 0ms (100%)
 * Memory : 38.1 mb (6.37%)
 */
public class Solution_3 implements Predicate<List, Object> {
	public class ReverseNode {
		public ListNode node;
		public ReverseNode prev;

		public ReverseNode(ListNode node, ReverseNode prev) {
			this.node = node;
			this.prev = prev;
		}
	}
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

		int nodeCnt = 0;
		ReverseNode rNode = new ReverseNode(cur, null);
		while(cur != null) {
			cur = cur.next;
			ReverseNode temp = new ReverseNode(cur, rNode);
			rNode = temp;
			nodeCnt++;
		}

		if(nodeCnt == n) {
			head = head.next;
			return head;
		}

		for(int i = 0; i < n - 1; i++) {
			rNode = rNode.prev;
		}

		rNode.prev.prev.node.next = rNode.node;

		return head;
	}
}
