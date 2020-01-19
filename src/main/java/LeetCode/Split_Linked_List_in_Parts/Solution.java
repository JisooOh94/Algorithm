package LeetCode.Split_Linked_List_in_Parts;

public class Solution {
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}


	public static ListNode[] splitListToParts(ListNode root, int partCnt) {
		ListNode[] resultList = new ListNode[partCnt];
		ListNode cur;
		int size = 0;

		cur = root;
		while(cur != null) {
			size++;
			cur = cur.next;
		}

		int baseSize = size / partCnt;

		if(baseSize == 0) {
			cur = root;
			for(int i = 0; i < partCnt; i++) {
				if(i >= size) {
					resultList[i] = null;
				} else {
					resultList[i] = new ListNode(cur.val);
					cur = cur.next;
				}
			}
			return resultList;
		}

		int leftSize = size % partCnt;

		cur = root;
		for(int outerIdx = 0; outerIdx < partCnt; outerIdx++) {
			int partSize = outerIdx < leftSize ? baseSize + 1 : baseSize;

			ListNode partCur = new ListNode(cur.val);
			resultList[outerIdx] = partCur;
			cur = cur.next;

			for(int innerIdx = 0; innerIdx < partSize - 1; innerIdx++) {
				ListNode newNode = new ListNode(cur.val);
				partCur.next = newNode;
				partCur = partCur.next;
				cur = cur.next;
			}
		}

		return resultList;
	}

	public static ListNode[] splitListToParts_2(ListNode root, int partCnt) {
		ListNode[] resultList = new ListNode[partCnt];
		ListNode cur, rem;
		int size = 0;

		cur = root;
		while(cur != null) {
			size++;
			cur = cur.next;
		}

		int baseSize = size / partCnt;

		if(baseSize == 0) {
			cur = rem = root;
			for(int i = 0; i < partCnt; i++) {
				if(i >= size) {
					resultList[i] = null;
				} else {
					resultList[i] = cur;
					cur = cur.next;
					rem.next = null;
					rem = cur;
				}
			}
			return resultList;
		}

		int leftSize = size % partCnt;

		cur = rem = root;
		for(int outerIdx = 0; outerIdx < partCnt; outerIdx++) {
			int partSize = outerIdx < leftSize ? baseSize + 1 : baseSize;
			resultList[outerIdx] = cur;
			for(int innerIdx = 1; innerIdx < partSize; innerIdx++) {
				cur = cur.next;
			}
			rem = cur;
			cur = cur.next;
			rem.next = null;
		}
		return resultList;
	}
}
