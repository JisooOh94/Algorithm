package medium.Validate_Binary_Search_Tree;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtiem : 0ms(100.00%)
 * Memory : 38.5mb(81.15%
 * Time Complexity : O(n)
 */
public class Solution {
	@Test
	public void execute() {
		int val_1 = 2147483647;
		System.out.println(isValidBST(new TreeNode(val_1)));
	}
	private static final long RANGE = (long)Math.pow(2, 31);
	private boolean recursion (TreeNode cur, long min, long max) {
		if(cur == null) return true;
		return (min < cur.val && cur.val < max) && (cur.left == null || recursion(cur.left, min, cur.val)) && (cur.right == null || recursion(cur.right, cur.val, max));
	}
	public boolean isValidBST(TreeNode root) {
		return recursion(root, RANGE * -1 -1, RANGE + 1);
	}
}
