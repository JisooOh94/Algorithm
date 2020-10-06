package medium.Maximum_Difference_Between_Node_and_Ancestor;

import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.7mb(88.17%)
 */
public class Solution {
	private int recursion(TreeNode cur, int maxVal, int minVal) {
		if(cur == null) return 0;

		int maxGap = maxVal != -1 ? Math.max(Math.abs(cur.val - maxVal), Math.abs(cur.val - minVal)) : 0;
		maxVal = maxVal != -1 ? Math.max(cur.val, maxVal) : cur.val;
		minVal = minVal != -1 ? Math.min(cur.val, minVal) : cur.val;
		maxGap = Math.max(maxGap, recursion(cur.left, maxVal, minVal));
		maxGap = Math.max(maxGap, recursion(cur.right, maxVal, minVal));

		return maxGap;
	}
	public int maxAncestorDiff(TreeNode root) {
		return recursion(root, -1, -1);
	}
}
