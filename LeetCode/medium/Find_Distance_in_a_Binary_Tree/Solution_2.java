package medium.Find_Distance_in_a_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 2ms(52.44%)
 * Memory : 48.9mb(18.29%%)
 * Time Complexity : O(n)
 */
public class Solution_2 {
	private TreeNode found;
	private Integer result;

	private int recursion(TreeNode cur, int p, int q) {
		if(cur == null || result != null) return 0;
		else if(cur.val == p || cur.val == q) {
			found = cur;
			return 1;
		}

		int leftResult = recursion(cur.left, p, q);
		int rightResult = recursion(cur.right, p, q);

		if(leftResult != 0 && rightResult != 0) {
			result = leftResult + rightResult;
		} else if(leftResult != 0 || rightResult != 0) {
			return leftResult + rightResult + 1;
		}

		return 0;
	}

	private int postProcess(TreeNode cur, int val, int depth) {
		if(cur == null) return 0;
		else if(cur.val == val) return depth;

		return postProcess(cur.left, val, depth + 1) + postProcess(cur.right, val, depth + 1);
	}

	public int findDistance(TreeNode root, int p, int q) {
		if(p == q) return 0;

		recursion(root, p, q);
		return result != null ? result : postProcess(found, found.val == p ? q : p, 0);
	}
}
