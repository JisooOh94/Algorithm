package medium.Find_Largest_Value_in_Each_Tree_Row;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * Runtime : 1ms(92.01%)
 * Memory : 39.2mb(7.85%)
 */
public class Solution {
	private void recursion (TreeNode cur, int depth, List<Integer> maxList) {
		if(cur == null) return;
		else if(maxList.size() == depth) maxList.add(cur.val);
		else maxList.set(depth, Math.max(maxList.get(depth), cur.val));

		recursion(cur.left, depth + 1, maxList);
		recursion(cur.right, depth + 1, maxList);
	}
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> maxList = new LinkedList<>();
		recursion(root, 0, maxList);
		return maxList;
	}
}
