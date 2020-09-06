package util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public static void printTree(TreeNode root) {
		if(root !=  null) {
			System.out.print(root.val + ", ");
			printTree(root.left);
			printTree(root.right);
		} else {
			System.out.print("null, ");
		}
	}
}