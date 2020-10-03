package medium.Deepest_Leaves_Sum;

import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 40.7mb(69.38%)
 */
public class Solution {
	private static final int DEPTH_IDX = 0;
	private static final int SUM_IDX = 1;
	private int[] recursion(TreeNode cur, int depth) {
		if(cur.left == null && cur.right == null) return new int[]{depth, cur.val};

		int[] maxLeafSum;
		if(cur.left != null && cur.right != null) {
			int[] leftLeafSum = recursion(cur.left, depth + 1);
			int[] rightLeafSum = recursion(cur.right, depth + 1);
			maxLeafSum = leftLeafSum[DEPTH_IDX] == rightLeafSum[DEPTH_IDX] ? new int[]{rightLeafSum[DEPTH_IDX], leftLeafSum[SUM_IDX] + rightLeafSum[SUM_IDX]} : leftLeafSum[DEPTH_IDX] > rightLeafSum[DEPTH_IDX] ? leftLeafSum : rightLeafSum;
		} else if(cur.left != null) maxLeafSum = recursion(cur.left, depth + 1);
		else maxLeafSum = recursion(cur.right, depth + 1);

		return maxLeafSum;
	}
	public int deepestLeavesSum(TreeNode root) {
		return recursion(root, 0)[SUM_IDX];
	}
}
