package medium.Binary_Tree_Zigzag_Level_Order_Traversal;

import org.junit.Test;
import util.PerformanceUtil;
import util.TreeNode;

public class Executor {
	@Test
	public void test() {
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		PerformanceUtil.calcPerformance(new Solution(), root);
	}
}
