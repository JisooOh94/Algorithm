package medium.Flatten_a_Multilevel_Doubly_Linked_List;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 38.2mb(9.68%)
 */
public class Solution {
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	};

	private void connect(Node from, Node to) {
		from.next = to;
		to.prev = from;
	}

	private Node recursion (Node cur) {
		while(cur != null) {
			Node next = cur.next;
			if(cur.child != null) {
				connect(cur, cur.child);
				cur.child = null;
				Node lastNode = recursion(cur.next);
				if(next == null) return lastNode;
				else connect(lastNode, next);
			}
			if(next == null) break;
			cur = next;
		}
		return cur;
	}
	public Node flatten(Node head) {
		recursion(head);
		return head;
	}
}
