package medium.Maximum_Product_of_Splitted_Binary_Tree;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 7ms(95.95%)
 * Memory : 56.4mb(63.20%)
 */
public class Solution {
	@Test
	public void execute() {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(6);

		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(6);

		System.out.println(maxProduct(root));
	}

	private static final int MOD = (int)Math.pow(10, 9) + 7;
	private static int maxNum = 0;

	private int recursion (TreeNode cur, int totalSum) {
		if(cur == null) return 0;

		int curSum = cur.val + recursion(cur.left, totalSum) + recursion(cur.right, totalSum);
		maxNum = Math.max(maxNum, (int)(((long)curSum * (long)(totalSum - curSum)) % MOD));
		return curSum;
	}

	private int getSum (TreeNode cur) {
		if(cur == null) return 0;

		return cur.val + getSum(cur.left) + getSum(cur.right);
	}

	public int maxProduct(TreeNode root) {
		int totalSum = root.val + getSum(root.left) + getSum(root.right);
		recursion(root, totalSum);
		return maxNum;
	}
}
