package medium.Binary_Tree_Right_Side_View;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * Runtime : 1ms(78.16%)
 * Memory : 37.9mb(13.08%)
 */
public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		if(root == null) return Collections.emptyList();
		List<Integer> result = new LinkedList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				if(i == size - 1) result.add(node.val);

				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
		}

		return result;
	}
}
