package Boundary_of_Binary_Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;
import util.TreeNode;

/**
 * Runtime : 1ms(50%)
 * Memory : 39.9mb(20%)
 */
public class Solution implements Predicate<List<Integer>, Object> {
	public List<Integer> test(Object... params) {
		return boundaryOfBinaryTree((TreeNode)params[0]);
	}

	private List<Integer> boundary = new LinkedList<>();
	private List<Integer> rightBoundary = new LinkedList<>();

	private boolean isLeafNode(TreeNode cur) {
		return cur.right == null && cur.left == null ? true : false;
	}

	private void searchLeftBoundary(TreeNode cur) {
		if(isLeafNode(cur)) {
			return;
		}
		boundary.add(cur.val);
		searchLeftBoundary(cur.left != null ? cur.left : cur.right);
	}

	private void searchLeafNodes(TreeNode cur) {
		if(isLeafNode(cur)) {
			boundary.add(cur.val);
			return;
		}

		if(cur.left != null) searchLeafNodes(cur.left);
		if(cur.right != null) searchLeafNodes(cur.right);
	}

	private void searchRightBoundary(TreeNode cur) {
		if(isLeafNode(cur)) {
			Collections.reverse(rightBoundary);
			boundary.addAll(rightBoundary);
			return;
		}
		rightBoundary.add(cur.val);
		searchRightBoundary(cur.right != null ? cur.right : cur.left);
	}

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if(root == null) {
			return Collections.EMPTY_LIST;
		} else if(root.left == null && root.right == null) {
			return Arrays.asList(root.val);
		}

		if(root.left != null) {
			searchLeftBoundary(root);
		} else {
			boundary.add(root.val);
		}

		searchLeafNodes(root);

		if(root.right != null) {
			searchRightBoundary(root.right);
		}

		return boundary;
	}
}
