package medium.Smallest_Subtree_with_all_the_Deepest_Nodes;

import util.TreeNode;

/**
 * Runtime : 1ms(35.56%)
 * Memory : 36.6mb(96.78%)
 * Time Complexity : O(n)
 */
public class Solution {
	private Object[] recursion(TreeNode cur, int depth) {
		if(cur.left == null && cur.right == null) return new Object[]{depth, cur};

		if(cur.left != null && cur.right != null) {
			Object[] left = recursion(cur.left, depth + 1);
			Object[] right = recursion(cur.right, depth + 1);
			return left[0] == right[0] ? new Object[]{left[0], cur} : (int)left[0] > (int)right[0] ? left : right;
		}
		return cur.left != null ? recursion(cur.left, depth + 1) : recursion(cur.right, depth + 1);
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		return (TreeNode) recursion(root, 0)[1];
	}
}
