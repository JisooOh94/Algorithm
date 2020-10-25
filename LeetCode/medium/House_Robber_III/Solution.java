package medium.House_Robber_III;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 979ms(11.83%)
 * Memory : 38.5mb(10.50%)
 */
public class Solution {
	private int recursion (TreeNode cur, boolean neighborSelected) {
		if(cur == null) return 0;

		int max = 0;
		if(!neighborSelected) {
			int selectedLeftResult = recursion(cur.left, true);
			int selectedRightResult= recursion(cur.right, true);
			max = cur.val + selectedLeftResult + selectedRightResult;
		}

		int leftResult = recursion(cur.left, false);
		int rightResult = recursion(cur.right, false);

		max = Math.max(max, leftResult + rightResult);
		return max;
	}
	public int rob(TreeNode root) {
		return recursion(root, false);
	}
}
