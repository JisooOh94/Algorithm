package medium.Linked_List_in_Binary_Tree;

import org.junit.Test;
import util.ListNode;
import util.TreeNode;

public class Solution {
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
	private boolean recursion (TreeNode cur, ListNode target, ListNode head) {
		if(target == null) return  true;
		else if(cur == null) return false;

		if(cur.val == target.val) {
			if(recursion(cur.left, target.next, head) || recursion(cur.right, target.next, head)) return true;
			else return false;
		} else if(target == head){
			return recursion(cur.left, head, head) || recursion(cur.right, head, head);
		} else {
			return recursion(cur, head, head);
		}
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		return recursion(root, head, head);
	}
}
