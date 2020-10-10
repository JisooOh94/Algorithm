package medium.Nested_List_Weight_Sum_II;

import java.util.List;

import util.NestedInteger;

/**
 * Runtime : 1ms(46.86%)
 * Memory : 36.7mb(14.78%)
 */
public class Solution {
	private int findMaxDepth(int curIdx, int curDepth, List<NestedInteger> list) {
		if(curIdx == list.size()) return 0;

		return list.get(curIdx).isInteger() ? Math.max(curDepth, findMaxDepth(curIdx + 1, curDepth, list)) :
				Math.max(findMaxDepth(0, curDepth + 1, list.get(curIdx).getList()), findMaxDepth(curIdx + 1, curDepth, list));
	}
	private int recursion(int curIdx, List<NestedInteger> list, int depth, int maxDepth) {
		if(curIdx == list.size()) return 0;
		NestedInteger cur = list.get(curIdx);
		return cur.isInteger() ? cur.getInteger() * (maxDepth - depth) + recursion(curIdx + 1, list, depth, maxDepth) : recursion(0, cur.getList(), depth + 1, maxDepth) + recursion(curIdx + 1, list, depth, maxDepth);
	}
	public int depthSumInverse(List<NestedInteger> nestedList) {
		return recursion(0, nestedList, 1, findMaxDepth(0, 1, nestedList) + 1);
	}
}
