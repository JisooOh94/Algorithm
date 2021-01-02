package medium.Flip_Binary_Tree_To_Match_Preorder_Traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.TreeNode;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Runtime : 1ms(15.26 %)
 * Memory : 38.8mb(93.68%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.right.left = new TreeNode(3);

		int[] voyage = new int[]{2, 4, 3, 1, 5};
		List<Integer> result = flipMatchVoyage(root, voyage);
		System.out.println(result);
	}

	private int idx = 0;
	private boolean recursion(TreeNode cur, int[] voyage, List<Integer> flipped) {
		if(cur == null) return true;
		else if(cur.val != voyage[idx++]) return false;

		if(cur.left != null && cur.left.val != voyage[idx]) {
			flipped.add(cur.val);
			return recursion(cur.right, voyage, flipped) && recursion(cur.left, voyage, flipped);
		} else {
			return recursion(cur.left, voyage, flipped) && recursion(cur.right, voyage, flipped);
		}
	}

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> flipped = new LinkedList<>();
		return recursion(root, voyage, flipped) ? flipped : Arrays.asList(-1);
	}
}
