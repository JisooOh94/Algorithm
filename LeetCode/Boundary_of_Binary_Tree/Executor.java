package Boundary_of_Binary_Tree;

import java.util.List;

import org.junit.Test;
import util.TreeNode;

public class Executor {


	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		TreeNode node_2 = root.left;
		TreeNode node_3 = root.right;

		node_2.left = new TreeNode(4);
		node_2.right = new TreeNode(5);

		node_3.left = new TreeNode(6);

		TreeNode node_5 = node_2.right;
		TreeNode node_6 = node_3.left;

		node_5.left = new TreeNode(7);
		node_5.right = new TreeNode(8);

		node_6.left = new TreeNode(9);
		node_6.right = new TreeNode(10);

		Solution solution = new Solution();
		List<Integer> boundary = solution.boundaryOfBinaryTree(root);

		for(Integer node : boundary) {
			System.out.print(node + " ");
		}
		System.out.println();
	}
}
