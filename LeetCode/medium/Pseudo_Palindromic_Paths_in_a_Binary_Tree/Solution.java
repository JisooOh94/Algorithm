package medium.Pseudo_Palindromic_Paths_in_a_Binary_Tree;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 5ms(85.82%)
 * Memory : 57.4mb(87.53%)
 */
public class Solution {
	@Test
	public void execute() {
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(1);
		node.right = new TreeNode(1);
		node.right.right = new TreeNode(1);

		System.out.println(pseudoPalindromicPaths(node));
	}
	private boolean palindromeChk (int[] cntArr) {
		boolean isPalindrome = true;
		for(int cnt : cntArr) {
			if(cnt % 2 != 0) {
				if(!isPalindrome) return false;
				isPalindrome = false;
			}
		}
		return true;
	}
	private int recursion (TreeNode cur, int[] cntArr) {
		int palindromeCnt = 0;
		cntArr[cur.val]++;

		if(cur.left == null && cur.right == null) {
			palindromeCnt = palindromeChk(cntArr) ? 1 : 0;
		} else {
			if(cur.left != null) palindromeCnt += recursion(cur.left, cntArr);
			if(cur.right != null ) palindromeCnt += recursion(cur.right, cntArr);
		}

		cntArr[cur.val]--;
		return palindromeCnt;
	}
	public int pseudoPalindromicPaths (TreeNode root) {
		int[] cntArr = new int[10];
		return recursion(root, cntArr);
	}
}
