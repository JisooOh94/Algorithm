package medium.Binary_Tree_Level_Order_Traversal_II;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * Runtime : 1ms(84.86%)
 * Memory : 39.2mb(69.67%)
 * Time Complexity : O(n)
 */
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null) return Collections.emptyList();
		Queue<TreeNode> queue = new LinkedList<>();
		LinkedList<List<Integer>> result = new LinkedList<>();

		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> curLevelList = new LinkedList<>();
			int curLevelNodeCnt = queue.size();
			for(int i = 0; i < curLevelNodeCnt; i++) {
				TreeNode cur = queue.poll();
				curLevelList.add(cur.val);
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
			}
			result.addFirst(curLevelList);
		}

		return result;
	}
}
