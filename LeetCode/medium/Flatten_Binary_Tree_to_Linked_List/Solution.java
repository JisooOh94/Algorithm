package medium.Flatten_Binary_Tree_to_Linked_List;

import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 38.5mb(16.08%)
 */
public class Solution {
	private TreeNode recursion(TreeNode parent, TreeNode child) {
		TreeNode rightChild = child.right;

		parent.left = null;
		parent.right = child;
		TreeNode leftLastNode = child.left != null ? recursion(child, child.left) : child;
		TreeNode rightLstNode = rightChild != null ? recursion(leftLastNode, rightChild) : leftLastNode;

		return rightLstNode;
	}
	public void flatten(TreeNode root) {
		if(root == null) return;
		recursion(new TreeNode(), root);
	}
}
