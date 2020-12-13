package medium.Sum_Root_to_Leaf_Numbers;

import util.TreeNode;

/**
 * Runtime : 1ms(25.63%
 * Memory : 38.1mb(8.86%)
 */
public class Solution {
	private int totalSum = 0;
	private void recursion(TreeNode cur, StringBuilder builder) {
		if(cur == null) return;

		builder.append(cur.val);

		if(cur.left == null && cur.right == null) {
			totalSum += Integer.parseInt(builder.toString());
		} else {
			recursion(cur.left, builder);
			recursion(cur.right, builder);
		}
		builder.deleteCharAt(builder.length() - 1);
	}

	public int sumNumbers(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		recursion(root, builder);
		return totalSum;
	}
}
