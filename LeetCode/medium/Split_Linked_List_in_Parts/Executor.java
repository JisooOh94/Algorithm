package medium.Split_Linked_List_in_Parts;

import org.junit.Test;
import util.ListNode;

public class Executor {
	ListNode root = makeList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	int partCnt = 3;

	private ListNode makeList1000() {
		ListNode root = null, cur = null;
		for(int i = 0; i < 1000; i++) {
			ListNode newNode = new ListNode(i);
			if(cur == null) {
				root = cur = newNode;
			} else {
				cur.next = newNode;
				cur = cur.next;
			}
		}
		return root;
	}

	private ListNode makeList(int... args) {
		ListNode root = null, cur = null;
		for(Integer value : args) {
			ListNode newNode = new ListNode(value);
			if(cur == null) {
				root = cur = newNode;
			} else {
				cur.next = newNode;
				cur = cur.next;
			}
		}
		return root;
	}

	private void printResultList(ListNode[] resultList) {
		System.out.print("[");
		for(int i = 0; i < partCnt; i++) {
			System.out.print("[");
			ListNode cur = resultList[i];
			while(cur != null) {
				System.out.print(cur.val);
				if(cur.next != null) {
					System.out.print(",");
				}
				cur = cur.next;
			}
			System.out.print("]");
			if(i != partCnt - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
	@Test
	public void execute() {
		//ListNode root = makeList1000();
		ListNode[] resultList = Solution.splitListToParts_2(root, partCnt);

		printResultList(resultList);
	}
}
