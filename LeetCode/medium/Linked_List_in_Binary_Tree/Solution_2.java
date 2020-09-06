package medium.Linked_List_in_Binary_Tree;

import org.junit.Test;
import util.ListNode;
import util.TreeNode;

/**
 * Runtime : 1ms(99.86%)
 * Memory : 39.6mb(78.85%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		ListNode head = ListNode.makeList(4,2,8);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);

		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(8);
		root.right.left.right.left = new TreeNode(1);
		root.right.left.right.right = new TreeNode(3);
		System.out.println(isSubPath(head, root));
	}
	private boolean isValid(ListNode target, TreeNode cur) {
		if(target == null) return true;
		else if(cur == null) return false;

		if(target.val == cur.val) return isValid(target.next, cur.left) || isValid(target.next, cur.right);
		else return false;
	}

	private boolean recursion (TreeNode cur, ListNode head) {
		if(cur == null) return false;

		if(cur.val == head.val && isValid(head, cur)) return true;
		else return recursion(cur.left, head) || recursion(cur.right, head);
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		return recursion(root, head);
	}
}
