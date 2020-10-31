package medium.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 5ms(18.33%)
 * Memory : 39mb(6.36%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] preorder = new int[]{1, 2};
		int[] inorder = new int[]{2, 1};
		TreeNode root = buildTree(preorder, inorder);
		int a = 0;
	}
	int midIdx = -1;
	private TreeNode recursion(int from, int to, int[] preorder, int[] inorder) {
		if(from == to) return null;
		midIdx++;
		if(from == to -1) return new TreeNode(inorder[from]);

		int m = -1;
		for(int i = from; i < to && m == -1; i++) if(inorder[i] == preorder[midIdx]) m = i;

		TreeNode cur = new TreeNode(inorder[m]);
		cur.left = recursion(from, m, preorder, inorder);
		cur.right = recursion(m + 1, to, preorder, inorder);

		return cur;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0) return null;
		return recursion(0, inorder.length, preorder, inorder);
	}
}
