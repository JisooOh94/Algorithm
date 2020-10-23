package medium.Number_of_Good_Leaf_Nodes_Pairs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 14ms(42.36%)
 * Memory : 39.7mb(7.80%)
 */
public class Solution {
	@Test
	public void execute() {
		List<Integer> list = new LinkedList<>();
		list.addAll(Arrays.asList(1,2,3,4,5));

		int idx = 0;
		for(Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			int val = iter.next();
			list.set(idx, val + 1);
			idx++;
		}
		int a = 0;
	}
	private int goodCnt = 0;
	private List<Integer> recursion(TreeNode cur, int dist) {
		if(cur.left == null && cur.right == null) return new LinkedList<>(Arrays.asList(1));

		List<Integer> leftResult = cur.left != null ? recursion(cur.left, dist) : new LinkedList<>();
		List<Integer> rightResult = cur.right != null ? recursion(cur.right, dist) : new LinkedList<>();

		if(!leftResult.isEmpty() && !rightResult.isEmpty()) {
			for (Iterator<Integer> leftIter = leftResult.iterator(); leftIter.hasNext(); ) {
				int leftVal = leftIter.next();
				for (Iterator<Integer> rightIter = rightResult.iterator(); rightIter.hasNext(); ) {
					int rightVal = rightIter.next();
					if (leftVal + rightVal <= dist) goodCnt++;
					else break;
				}
			}
		}
		leftResult.addAll(rightResult);
		Collections.sort(leftResult);

		int idx = 0;
		for(Iterator<Integer> iter = leftResult.iterator(); iter.hasNext();) {
			int modifVal = iter.next() + 1;
			if(modifVal > dist) iter.remove();
			else leftResult.set(idx, modifVal);
			idx++;
		}

		return leftResult;
	}
	public int countPairs(TreeNode root, int distance) {
		recursion(root, distance);
		return goodCnt;
	}
}
