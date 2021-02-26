package medium.Binary_Tree_Level_Order_Traversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * Runtime : 1ms(61.19%)
 * Memory : 39.5mb(33.21%)
 * Time Complexity : O(n)
 */
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return Collections.emptyList();
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();

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
			result.add(curLevelList);
		}

		return result;
	}
}
