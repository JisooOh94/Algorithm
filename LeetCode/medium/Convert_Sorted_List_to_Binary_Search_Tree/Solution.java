package medium.Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;
import util.TreeNode;

/**
 * Runtime : 3ms(7.4%)
 * Memory : 44.3mb(5.08%)
 */
public class Solution {
	private TreeNode recursion(int start, int end, List<Integer> list) {
		if(start == end) return new TreeNode(list.get(start));
		else if(end < start) return null;

		int curIdx = (start + end) / 2;
		TreeNode cur = new TreeNode(list.get(curIdx));
		cur.left = recursion(start, curIdx - 1, list);
		cur.right = recursion(curIdx + 1, end, list);
		return cur;
	}
	public TreeNode sortedListToBST(ListNode head) {
		ListNode cur = head;
		List<Integer> list = new ArrayList<>();
		while(cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}

		return recursion(0, list.size() - 1, list);
	}
}
