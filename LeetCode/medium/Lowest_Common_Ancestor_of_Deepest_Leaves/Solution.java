package medium.Lowest_Common_Ancestor_of_Deepest_Leaves;

import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 38.7mb(46.83%)
 */
public class Solution {
	private static final Object[] DEFAULT = new Object[]{null, -1};
	private Object[] recursion(TreeNode cur, int depth) {
		if(cur == null) return DEFAULT;
		else if(cur.left == null && cur.right == null) return new Object[]{cur, depth};

		Object[] leftR = recursion(cur.left, depth + 1);
		Object[] rightR = recursion(cur.right, depth + 1);

		if(leftR[1] == rightR[1]) return new Object[]{cur, leftR[1]};
		else if((int)leftR[1] > (int)rightR[1]) return leftR;
		else return rightR;
	}
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		Object[] result = recursion(root, 0);
		return (TreeNode)result[0];
	}
}
