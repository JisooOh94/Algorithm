package medium.Clone_N_ary_Tree;

import java.util.List;

import util.ListNode;

/**
 * Runtime : 1ms(93.04%)
 * Memory : 40.7mb(97.76%)
 */
public class Solution {
	public class ListNode {
		private int val;
		private List<ListNode> children;

		public ListNode (int val) {
			this.val = val;
		}
	}
	private ListNode recurion(ListNode cur) {
		ListNode copy = new ListNode(cur.val);
		List<ListNode> childList = copy.children;

		for(ListNode child : cur.children) {
			childList.add(recurion(child));
		}

		return copy;
	}
	public ListNode cloneTree(ListNode root) {
		if(root == null) return null;
		return recurion(root);
	}
}
