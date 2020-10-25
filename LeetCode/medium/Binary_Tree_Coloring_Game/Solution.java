package medium.Binary_Tree_Coloring_Game;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.7mb(14.06%)
 */
public class Solution {
	@Test
	public void execute() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(btreeGameWinningMove(root, 7,1));
	}
	private static final int LEFT_CHILD = 1;
	private static final int RIGHT_CHILD = 2;
	private int leftChildCnt = 0;
	private int rightChildCnt = 0;
	private int recursion (TreeNode cur, int x, int isChild) {
		if(cur == null) return 0;

		int nodeCnt = 1;
		if(cur.val == x) {
			nodeCnt += recursion(cur.left, x, LEFT_CHILD) + recursion(cur.right, x, RIGHT_CHILD);
		} else {
			nodeCnt += recursion(cur.left, x, isChild) + recursion(cur.right, x, isChild);
			if(isChild == LEFT_CHILD) leftChildCnt += 1;
			else if(isChild == RIGHT_CHILD) rightChildCnt += 1;
		}
		return nodeCnt;
	}
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		int totalNodeCnt = recursion(root, x, 0);

		int whenChooseParent = leftChildCnt + rightChildCnt + 1;
		int whenChooseLeftChild = totalNodeCnt - leftChildCnt;
		int whenChooseRightChild = totalNodeCnt - rightChildCnt;

		return (totalNodeCnt - whenChooseParent) > whenChooseParent ||
				leftChildCnt > whenChooseLeftChild ||
				rightChildCnt > whenChooseRightChild;
	}
}
