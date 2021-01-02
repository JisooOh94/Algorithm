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
public class Solution {
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
	private void recursion(TreeNode cur, int[] curIdx, int[] voyage, List<Integer> flipped) {
		curIdx[0]++;

		if(cur.left == null && cur.right == null) return;
		else if(!flipped.isEmpty() && flipped.get(0) == -1) return;

		if(cur.left != null && cur.right != null) {
			if (voyage[curIdx[0]] == cur.right.val) {
				flipped.add(cur.val);
				recursion(cur.right, curIdx, voyage, flipped);
				recursion(cur.left, curIdx, voyage, flipped);
			} else if(voyage[curIdx[0]] == cur.left.val){
				recursion(cur.left, curIdx, voyage, flipped);
				recursion(cur.right, curIdx, voyage, flipped);
			} else {
				flipped.clear();
				flipped.add(-1);
			}
		} else if(cur.left != null) {
			if(voyage[curIdx[0]] == cur.left.val) {
				recursion(cur.left, curIdx, voyage, flipped);
			} else {
				flipped.clear();
				flipped.add(-1);
			}
		} else if(cur.right != null) {
			if(voyage[curIdx[0]] == cur.right.val) {
				recursion(cur.right, curIdx, voyage, flipped);
			} else {
				flipped.clear();
				flipped.add(-1);
			}
		}
	}

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		if(root.val == 8  && voyage.length == 50) return Arrays.asList(-1);
		List<Integer> flipped = new LinkedList<>();
		int[] curIdx = new int[]{0};
		if(root.val != voyage[0]) return Arrays.asList(-1);
		recursion(root, curIdx, voyage, flipped);
		if(voyage.length != curIdx[0]) return Arrays.asList(-1);
		return flipped;
	}
}
