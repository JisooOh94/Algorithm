package medium.Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 38.4mb(93.37%)
 * Time Complexity : O(n)
 */
public class Solution {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	private void recursion(Node cur, int depth, List<Node> list) {
		if(cur == null) return;
		else if(list.size() == depth) list.add(cur);
		else {
			list.get(depth).next = cur;
			list.set(depth, cur);
		}

		recursion(cur.left, depth + 1, list);
		recursion(cur.right, depth + 1, list);
	}
	public Node connect(Node root) {
		List<Node> list = new ArrayList<>();
		recursion(root, 0, list);
		return root;
	}
}
