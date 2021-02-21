package medium.Maximum_Level_Sum_of_a_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * Runtime : 7ms(81.26%)
 * Memory : 41.6mb(91.74%)
 * Time Complexity : O(n)
 */
public class Solution {
	public int maxLevelSum(TreeNode root) {
		Long maxSum = null;
		int maxLevel = 0;
		int curLevel = 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int nodeCnt = queue.size();
			long curSum = 0;
			for(int i = 0; i < nodeCnt; i++) {
				TreeNode cur = queue.poll();
				curSum += cur.val;
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);

			}

			if(maxSum == null || curSum > maxSum) {
				maxSum = curSum;
				maxLevel = curLevel;
			}
			curLevel++;
		}
		return maxLevel + 1;
	}
}
