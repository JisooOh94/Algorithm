package medium.Unique_Binary_Search_Trees_II;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 1ms(97.90%)
 * Memory : 39.2mb(98.16%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 3;
		List<TreeNode> resultList = generateTrees(n);

		for(TreeNode node: resultList) {
			TreeNode.printTree(node);
			System.out.println();
		}
	}
	private static final List<TreeNode> NULL_LIST = new LinkedList<TreeNode>(Arrays.asList(new TreeNode[]{null}));
	private List<TreeNode> recursion(int startNum, int endNum, List<TreeNode>[][] record) {
		if(endNum < startNum) return NULL_LIST;
		else if(record[startNum][endNum] != null) return record[startNum][endNum];

		List<TreeNode> list = new LinkedList<>();
		for(int i = startNum; i <= endNum; i++) {
			List<TreeNode> leftSubList = recursion(startNum, i - 1, record);
			List<TreeNode> rightSubList = recursion(i + 1, endNum, record);

			for(int leftIdx = 0; leftIdx < leftSubList.size(); leftIdx++) {
				for(int rightIdx = 0; rightIdx < rightSubList.size(); rightIdx++) {
					TreeNode cur = new TreeNode(i);
					cur.left = leftSubList.get(leftIdx);
					cur.right = rightSubList.get(rightIdx);
					list.add(cur);
				}
			}
		}

		record[startNum][endNum] = list;
		return list;
	}

	public List<TreeNode> generateTrees(int n) {
		if(n == 0) return Collections.emptyList();
		List<TreeNode>[][] record = new LinkedList[n + 1][n + 1];
		return recursion(1, n, record);
	}
}
