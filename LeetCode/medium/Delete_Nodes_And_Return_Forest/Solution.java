package medium.Delete_Nodes_And_Return_Forest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 7ms(6.57%)
 * Memory : 39.5mb(96.64%)
 */
public class Solution {
	@Test
	public void execute() {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		int[] arr = new int[]{3, 5};

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		int[] arr = new int[]{2, 1};
		delNodes(root, arr);
	}
	private boolean inList(int val, List<Integer> delList) {
		for(Iterator<Integer> iter = delList.iterator(); iter.hasNext();) {
			int delVal = iter.next();
			if(val == delVal) {
				iter.remove();
				return true;
			} else if(val < delVal) {
				return false;
			}
		}
		return false;
	}
	private void recursion(TreeNode cur, boolean isDel, List<TreeNode> rootList, List<Integer> delList) {
		if(cur.left != null) {
			if (isDel) {
				if (inList(cur.left.val, delList)) {
					recursion(cur.left, true, rootList, delList);
				} else {
					rootList.add(cur.left);
					recursion(cur.left, false, rootList, delList);
				}
			} else {
				if (inList(cur.left.val, delList)) {
					recursion(cur.left, true, rootList, delList);
					cur.left = null;
				} else {
					recursion(cur.left, false, rootList, delList);
				}
			}
		}

		if(cur.right != null) {
			if (isDel) {
				if (inList(cur.right.val, delList)) {
					recursion(cur.right, true, rootList, delList);
				} else {
					rootList.add(cur.right);
					recursion(cur.right, false, rootList, delList);
				}
			} else {
				if (inList(cur.right.val, delList)) {
					recursion(cur.right, true, rootList, delList);
					cur.right = null;
				} else {
					recursion(cur.right, false, rootList, delList);
				}
			}
		}
	}
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> rootList = new LinkedList<>();
		Arrays.sort(to_delete);
		List<Integer> delList = new LinkedList<>(Arrays.stream(to_delete).boxed().collect(Collectors.toList()));
		if(inList(root.val, delList)) recursion(root, true, rootList, delList);
		else {
			rootList.add(root);
			recursion(root, false, rootList, delList);
		}
		return rootList;
	}
}
