package medium.Path_Sum_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/**
 * Runtime : 1ms(100.00%)
 * Memory : 39.5mb(48.72%)
 */
public class Solution {
	private void recursion(TreeNode cur, int curSum, int targetSum, Stack<Integer> path, List<List<Integer>> result) {
		if(cur.left == null && cur.right == null) {
			if(curSum == targetSum) result.add(new ArrayList<>(path));
			return;
		}

		TreeNode left = cur.left;
		TreeNode right = cur.right;

		if(left != null) {
			path.push(left.val);
			recursion(left, curSum + left.val, targetSum, path, result);
			path.pop();
		}

		if(right != null) {
			path.push(right.val);
			recursion(right, curSum + right.val, targetSum, path, result);
			path.pop();
		}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null || sum < root.val) return Collections.emptyList();
		List<List<Integer>> result = new LinkedList<>();
		Stack<Integer> path = new Stack<>();
		path.push(root.val);
		recursion(root, root.val, sum, path, result);
		return result;
	}
}
