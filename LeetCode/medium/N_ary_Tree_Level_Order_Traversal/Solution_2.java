package medium.N_ary_Tree_Level_Order_Traversal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 2ms(87.17%)
 * Memory : 40mb(58.10%)
 * Time Complexity : O(n)
 */
public class Solution_2 {
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
		Queue<List<Node>> queue = new LinkedList<>();
		List<List<Integer>> list = new LinkedList<>();

		queue.offer(Arrays.asList(root));

		while(!queue.isEmpty()) {
			int nodeCnt = queue.size();
			List<Integer> curList = new LinkedList<>();

			for(int i = 0; i < nodeCnt; i++) {
				List<Node> cur = queue.poll();
				for(Node node : cur) {
					curList.add(node.val);
					if(node.children != null && !node.children.isEmpty()) queue.offer(node.children);
				}
			}
			list.add(curList);
		}

		return list;
	}
}
