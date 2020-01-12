package LeetCode.AddTwoNumbers;

public class Executor {
	private static LeetCode.AddTwoNumbers.ListNode makeList(int... args) {
		LeetCode.AddTwoNumbers.ListNode head = null;
		LeetCode.AddTwoNumbers.ListNode cur = null;

		for(int value : args) {
			if(head == null) {
				head = new LeetCode.AddTwoNumbers.ListNode(value);
				cur = head;
			} else {
				cur.next = new LeetCode.AddTwoNumbers.ListNode(value);
				cur = cur.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		LeetCode.AddTwoNumbers.ListNode node_1 = makeList(2,4,3);
		LeetCode.AddTwoNumbers.ListNode node_2 = makeList(5,6,4);

		LeetCode.AddTwoNumbers.ListNode result = LeetCode.AddTwoNumbers.Solution.addTwoNumbers(node_1, node_2);

		LeetCode.AddTwoNumbers.ListNode cur = result;
		while(cur != null) {
			System.out.print(cur.val + " > ");
			cur = cur.next;
		}
	}
}
