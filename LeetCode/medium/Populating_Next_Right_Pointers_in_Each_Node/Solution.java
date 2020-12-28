package medium.Populating_Next_Right_Pointers_in_Each_Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 1ms(53.68%)
 * Memory : 39.5mb(21.47%)
 */
public class Solution {
	public class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int x) {
			val = x;
		}
	}

	private void recursion(Node cur, int depth, List<LinkedList<Node>> record) {
		if(record.size() == depth) {
			record.add(new LinkedList<>(Arrays.asList(cur)));
		} else {
			record.get(depth).getLast().next = cur;
			record.get(depth).add(cur);
		}

		if(cur.left != null) {
			recursion(cur.left, depth + 1, record);
			recursion(cur.right, depth + 1, record);
		}
	}

	public Node connect(Node root) {
		if(root == null || root.left == null) return root;
		List<LinkedList<Node>> record = new ArrayList<>();
		recursion(root, 0, record);
		return root;
	}
}
