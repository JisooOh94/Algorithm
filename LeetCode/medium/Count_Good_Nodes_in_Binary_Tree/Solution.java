package medium.Count_Good_Nodes_in_Binary_Tree;

import util.TreeNode;

/**
 * Runtime : 2ms(98.03%)
 * Memory : 47.9mb(89.99%)
 */
public class Solution {
	private int recursion(TreeNode cur, int prevVal) {
		if(cur == null) return 0;

		int cnt = prevVal <= cur.val ? 1 : 0;
		cnt += recursion(cur.left, prevVal <= cur.val ? cur.val : prevVal);
		cnt += recursion(cur.right, prevVal <= cur.val ? cur.val : prevVal);

		return cnt;
	}
	public int goodNodes(TreeNode root) {
		return recursion(root, -10001);
	}
}
