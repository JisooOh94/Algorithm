package medium.Distribute_Coins_in_Binary_Tree;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 38.2mb(97.63%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(0);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(0);
//		root.left.left.left.left = new TreeNode(2);
//		root.left.left.left.right = new TreeNode(1);
//		root.left.left.left.left.left = new TreeNode(0);
//		root.left.left.left.left.left.left = new TreeNode(0);
//		root.left.left.left.left.left.right = new TreeNode(4);

		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(0);
		root.left = new TreeNode(0);
		System.out.println(distributeCoins(root));
	}

	int moveCnt = 0;
	private int recursion(TreeNode cur) {
		if(cur == null) return 0;
		int moveCoin = cur.val - 1 + recursion(cur.left) + recursion(cur.right);
		moveCnt += Math.abs(moveCoin);

		return moveCoin;
	}
	public int distributeCoins(TreeNode root) {
		recursion(root);
		return moveCnt;
	}
}
