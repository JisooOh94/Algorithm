package medium.N_ary_Tree_Level_Order_Traversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 2ms(87.17%)
 * Memory : 40mb(58.10%)
 * Time Complexity : O(n^2)
 */
public class Solution {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<List<Integer>> levelOrder(Node root) {
		if(root == null) return Collections.emptyList();
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> list = new LinkedList<>();

		queue.offer(root);

		while(!queue.isEmpty()) {
			int nodeCnt = queue.size();
			List<Integer> curList = new LinkedList<>();

			for(int i = 0; i < nodeCnt; i++) {
				Node cur = queue.poll();
				curList.add(cur.val);
				for(Node child : cur.children) queue.offer(child);
			}

			list.add(curList);
		}

		return list;
	}
}
