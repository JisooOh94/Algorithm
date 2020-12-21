package medium.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 3ms(45.24%)
 * Memory : 38.8mb(89.90%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] inorder = new int[]{3, 2, 1};
		int[] postorder = new int[]{3, 2, 1};
		System.out.println(buildTree(inorder, postorder));
	}

	private int search(int from, int to, int[] arr, int target) {
		for(int i = from; i <= to; i++) if(arr[i] == target) return i;
		return -1;
	}
	private TreeNode recursion(int from, int to, int[] postRootIdx, int[] in, int[] post) {
		if(to < from) return null;
		postRootIdx[0]--;
		if(from == to) return new TreeNode(in[from]);

		TreeNode curRoot = new TreeNode(post[postRootIdx[0]]);
		int inRootIdx = search(from, to, in, post[postRootIdx[0]]);

		TreeNode rightChild = recursion(inRootIdx + 1, to, postRootIdx, in, post);
		TreeNode leftChild = recursion(from, inRootIdx - 1, postRootIdx, in, post);

		curRoot.left = leftChild;
		curRoot.right = rightChild;

		return curRoot;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || inorder.length == 0) return null;
		return recursion(0, inorder.length - 1, new int[]{postorder.length}, inorder, postorder);
	}
}
