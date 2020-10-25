package medium.House_Robber_III;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 3ms(43.43%)
 * Memory : 38.7mb(10.50%)
 */
public class Solution_2 {
	private static final int TRUE = 0;
	private static final int FALSE = 1;
	private int recursion (TreeNode cur, int neighborSelected, Map<TreeNode, Integer>[] record) {
		if(cur == null) return 0;
		else if(record[neighborSelected].containsKey(cur)) return record[neighborSelected].get(cur);

		int max = 0;
		if(neighborSelected == FALSE) {
			int selectedLeftResult = recursion(cur.left, TRUE, record);
			int selectedRightResult= recursion(cur.right, TRUE, record);
			max = cur.val + selectedLeftResult + selectedRightResult;
		}
		int leftResult = recursion(cur.left, FALSE, record);
		int rightResult = recursion(cur.right, FALSE, record);

		max = Math.max(max, leftResult + rightResult);

		record[neighborSelected].put(cur, max);
		return max;
	}
	public int rob(TreeNode root) {
		Map<TreeNode, Integer>[] record = new HashMap[2];
		record[0] = new HashMap<>();
		record[1] = new HashMap<>();
		return recursion(root, FALSE, record);
	}
}
