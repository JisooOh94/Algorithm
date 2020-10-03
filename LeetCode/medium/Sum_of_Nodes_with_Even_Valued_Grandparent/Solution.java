package medium.Sum_of_Nodes_with_Even_Valued_Grandparent;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 1ms(99.00%)
 * Memory : 41.1mb(85.34%)
 */
public class Solution {
	private int recursion(TreeNode cur, TreeNode parent, int gpVal) {
		if(cur == null) return 0;

		int sum = gpVal % 2 == 0 ? cur.val : 0;
		sum += recursion(cur.left, cur, parent.val);
		sum += recursion(cur.right, cur, parent.val);

		return sum;
	}

	public int sumEvenGrandparent(TreeNode root) {
		return recursion(root, new TreeNode(-1), -1);
	}
}
