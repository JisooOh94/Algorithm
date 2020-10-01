package medium.Find_Leaves_of_Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 1ms(26.92%)
 * Memory : 37.4mb(98.44%)
 */
public class Solution {
	@Test
	public void execute() {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);

		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);

		List<List<Integer>> result = findLeaves(root);
		for(List<Integer> list : result) {
			for(int num : list) System.out.print(num + " ");
			System.out.println();
		}
	}
	private List<List<Integer>> recursion(TreeNode curNode) {
		if(curNode.left == null && curNode.right == null) return Arrays.asList(new ArrayList<>(Arrays.asList(curNode.val)));

		List<List<Integer>> leaveList = new LinkedList<>();
		List<List<Integer>> leftLeaveList = curNode.left != null ? recursion(curNode.left) : Collections.emptyList();
		List<List<Integer>> rightLeaveList = curNode.right != null ? recursion(curNode.right) : Collections.emptyList();

		List<List<Integer>> sourceList = leftLeaveList.size() > rightLeaveList.size() ? leftLeaveList : rightLeaveList;
		List<List<Integer>> targetList = leftLeaveList.size() > rightLeaveList.size() ? rightLeaveList : leftLeaveList;

		leaveList.addAll(sourceList);
		for(int i = 0; i < targetList.size(); i++) {
			leaveList.get(i).addAll(targetList.get(i));
		}

		leaveList.add(new ArrayList<>(Arrays.asList(curNode.val)));
		return leaveList;
	}
	public List<List<Integer>> findLeaves(TreeNode root) {
		if(root == null) return Collections.emptyList();
		return recursion(root);
	}
}
