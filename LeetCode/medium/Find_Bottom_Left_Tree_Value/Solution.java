package medium.Find_Bottom_Left_Tree_Value;

import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.1mb(10.55%)
 */
public class Solution {
	private static final int VAL_IDX = 0;
	private static final int DEPTH_IDX = 1;
	int[] leftMostValue = new int[2];
	private void recursion (TreeNode cur, int depth) {
		if(cur.left == null && cur.right == null && depth > leftMostValue[DEPTH_IDX]) {
			leftMostValue[DEPTH_IDX] = depth;
			leftMostValue[VAL_IDX] = cur.val;
		}

		if(cur.left != null) recursion(cur.left, depth + 1);
		if(cur.right != null) recursion(cur.right, depth + 1);
	}

	public int findBottomLeftValue(TreeNode root) {
		recursion(root, 1);
		return leftMostValue[VAL_IDX];
	}
}
