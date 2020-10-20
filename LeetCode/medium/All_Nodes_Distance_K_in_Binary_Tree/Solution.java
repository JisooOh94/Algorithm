package medium.All_Nodes_Distance_K_in_Binary_Tree;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * Runtime : 13ms(60.78%)
 * Memory :39.5mb(6.14%)
 */
public class Solution {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> outputNodes = new LinkedList<>();
		findTarget(root, target.val, K, outputNodes);
		return outputNodes;
	}
	private void findChild(TreeNode cur, int targetDist, List<Integer> outputNodes) {
		if(cur == null) return;
		else if(targetDist == 0) {
			outputNodes.add(cur.val);
			return;
		}

		findChild(cur.left, targetDist - 1, outputNodes);
		findChild(cur.right, targetDist - 1, outputNodes);
	}
	private int findTarget(TreeNode cur, int target, int targetDist, List<Integer> outputNodes) {
		if(cur == null) {
			return -1;
		} else if(cur.val == target) {
			findChild(cur, targetDist, outputNodes);
			return 1;
		}

		int distFromTarget;
		distFromTarget = findTarget(cur.left, target, targetDist, outputNodes);
		if(distFromTarget != -1) {
			if(distFromTarget == targetDist) outputNodes.add(cur.val);
			else if(distFromTarget + 1 <= targetDist ) findChild(cur.right, targetDist - (distFromTarget + 1), outputNodes);
			return distFromTarget + 1;
		}

		distFromTarget = findTarget(cur.right, target, targetDist, outputNodes);
		if(distFromTarget != -1) {
			if(distFromTarget == targetDist) outputNodes.add(cur.val);
			else if(distFromTarget + 1 <= targetDist ) findChild(cur.left, targetDist - (distFromTarget + 1), outputNodes);
			return distFromTarget + 1;
		}

		return -1;
	}
}
