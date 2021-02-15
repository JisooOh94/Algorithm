package medium.Clone_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 27ms(30.33%)
 * Memory : 39mb(87.86%)
 * Time Complexity : O(E*N)
 */
public class Solution {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}
	}

	public Node cloneGraph(Node node) {
		if(node == null) return null;
		else if(node.neighbors.isEmpty()) return new Node(node.val);
		Node[] memo = new Node[101];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		memo[node.val] = new Node(node.val);

		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			Node cpy = memo[cur.val];

			for(Node neighbor : cur.neighbors) {
				if(memo[neighbor.val] == null) {
					Node newNode = new Node(neighbor.val);
					memo[neighbor.val] = newNode;
					queue.offer(neighbor);
					cpy.neighbors.add(newNode);
				} else {
					cpy.neighbors.add(memo[neighbor.val]);
				}
			}
		}
		return memo[node.val];
	}
}
