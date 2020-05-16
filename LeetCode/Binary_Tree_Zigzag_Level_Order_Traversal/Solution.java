package Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;
import util.TreeNode;

/**
 * Runtime : 2ms(7.21%)
 * Memory : 39.7mb(5.77%)
 */
public class Solution implements Predicate<List<List<Integer>>, Object> {
	public List<List<Integer>> test(Object... params) {
		return zigzagLevelOrder((TreeNode) params[0]);
	}

	public void recursion(List<TreeNode> nodeList, List<List<Integer>> numList, int start, int end, boolean isForward) {
		if (end < start) return;

		int newEnd = end;

		List<Integer> addedNums = new LinkedList<>();

		for (int i = end; start <= i; i--) {
			TreeNode cur = nodeList.get(i);
			if (isForward) {
				if (cur.left != null) {
					nodeList.add(cur.left);
					addedNums.add(cur.left.val);
					newEnd++;
				}

				if (cur.right != null) {
					nodeList.add(cur.right);
					addedNums.add(cur.right.val);
					newEnd++;
				}
			} else {
				if (cur.right != null) {
					nodeList.add(cur.right);
					addedNums.add(cur.right.val);
					newEnd++;
				}

				if (cur.left != null) {
					nodeList.add(cur.left);
					addedNums.add(cur.left.val);
					newEnd++;
				}
			}
		}

		if (!addedNums.isEmpty()) numList.add(addedNums);

		recursion(nodeList, numList, end + 1, newEnd, !isForward);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.EMPTY_LIST;
		}

		List<TreeNode> nodeList = new LinkedList<>();
		List<List<Integer>> numList = new LinkedList<>();

		nodeList.add(root);
		numList.add(Arrays.asList(root.val));

		recursion(nodeList, numList, 0, 0, false);

		return numList;
	}
}
