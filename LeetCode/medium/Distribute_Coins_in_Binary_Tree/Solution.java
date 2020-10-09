package medium.Distribute_Coins_in_Binary_Tree;

import java.util.LinkedList;

import org.junit.Test;
import util.TreeNode;

public class Solution {
	@Test
	public void execute() {
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(0);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(0);
//		root.left.left.left.left = new TreeNode(2);
//		root.left.left.left.right = new TreeNode(1);
//		root.left.left.left.left.left = new TreeNode(0);
//		root.left.left.left.left.left.left = new TreeNode(0);
//		root.left.left.left.left.left.right = new TreeNode(4);

		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.left = new TreeNode(0);
		root.right.left.left.left = new TreeNode(2);
		System.out.println(distributeCoins(root));
	}

	private static final String LEFT = "L";
	private static final String RIGHT = "R";

	private int recursion (TreeNode cur, StringBuffer code, LinkedList<TreeNode> richNodeList, LinkedList<String> richCodeList, LinkedList<String> poorCodeList) {
		if(cur == null) return 0;

		if(cur.val > 1) {
			richNodeList.add(cur);
			richCodeList.add(code.toString());
		} else if(cur.val == 0) {
			poorCodeList.add(code.toString());
		}

		if(cur.left == null && cur.right == null) return 0;

		int moveCnt = recursion(cur.left, code.append(LEFT), richNodeList, richCodeList, poorCodeList);
		code.deleteCharAt(code.length() - 1);
		moveCnt += recursion(cur.right, code.append(RIGHT), richNodeList, richCodeList, poorCodeList);
		code.deleteCharAt(code.length() - 1);

		while(!poorCodeList.isEmpty() && !richNodeList.isEmpty()) {
			String richNodeCode = richCodeList.getLast();
			String poorNodeCode = poorCodeList.pollLast();
			moveCnt += getDist(richNodeCode, poorNodeCode);
			if(--richNodeList.getLast().val == 1) {
				richNodeList.pollLast();
				richCodeList.pollLast();
			}
		}
		return moveCnt;
	}

	private int getDist(String from, String to) {
		for(int i = 0; i < Math.min(from.length(), to.length()); i++) if(from.charAt(i) != to.charAt(i)) return from.length() - i + to.length() - i;
		return Math.abs(from.length() - to.length());
	}

	public int distributeCoins(TreeNode root) {
		return recursion(root, new StringBuffer(), new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
	}
}
