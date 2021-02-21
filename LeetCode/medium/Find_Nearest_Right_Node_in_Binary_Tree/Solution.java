package medium.Find_Nearest_Right_Node_in_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * Runtime : 8ms(87.18%)
 * Memory : 50.2mb(92.46%)
 * Time Complexity : O(n)
 */
public class Solution {
	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int nodeCnt = queue.size();

			for(int i = 0; i < nodeCnt; i++) {
				TreeNode cur = queue.poll();
				if(cur.val == u.val) return i == nodeCnt - 1 ? null : queue.poll();
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
			}
		}
		return null;
	}
}
