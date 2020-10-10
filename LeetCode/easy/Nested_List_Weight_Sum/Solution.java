package easy.Nested_List_Weight_Sum;

import java.util.List;

import org.junit.Test;
import util.NestedInteger;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.6mb(17.41%)
 */
public class Solution {
	@Test
	private int recursion(int curIdx, List<NestedInteger> list, int depth) {
		if(curIdx == list.size()) return 0;
		NestedInteger cur = list.get(curIdx);
		return cur.isInteger() ? cur.getInteger() * depth + recursion(curIdx + 1, list, depth) : recursion(0, cur.getList(), depth + 1) + recursion(curIdx + 1, list, depth);
	}
	public int depthSum(List<NestedInteger> nestedList) {
		return recursion(0, nestedList, 1);
	}
}
