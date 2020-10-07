package medium.The_Earliest_Moment_When_Everyone_Become_Friends;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 7ms
 * Memory : 39.4mb
 */
public class Solution {
	private static final int HEAD = 0;
	private static final int TAIl = 1;
	private static final int FROM = 1;
	private static final int TO = 2;
	public class Node {
		int val;
		Node next;

		public Node(int val) { this.val = val; }
	}

	private boolean isContains(int elem, Node head) {
		Node cur = head;
		while(cur != null) {
			if(cur.val == elem) return true;
			cur = cur.next;
		}
		return false;
	}

	public int earliestAcq(int[][] logs, int N) {
		Arrays.sort(logs, (e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : 0);

		int componentCnt = N;
		List<Node[]> componentInfo = new LinkedList<>();
		for(int[] log : logs) {
			Node[] fromComponent = null, toComponent = null;
			for(Node[] component : componentInfo) {
				if(isContains(log[FROM], component[HEAD])) fromComponent = component;
				if(isContains(log[TO], component[HEAD])) toComponent = component;
			}

			if(fromComponent == null && toComponent == null) {
				Node head = new Node(log[FROM]);
				Node tail = new Node(log[TO]);
				head.next = tail;
				componentInfo.add(new Node[]{head, tail});
			} else if(fromComponent == null) {
				toComponent[TAIl].next = new Node(log[FROM]);
				toComponent[TAIl] = toComponent[TAIl].next;
			} else if(toComponent == null) {
				fromComponent[TAIl].next = new Node(log[TO]);
				fromComponent[TAIl] = fromComponent[TAIl].next;
			} else {
				if(fromComponent == toComponent) {
					continue;
				} else {
					fromComponent[TAIl].next = toComponent[HEAD];
					fromComponent[TAIl] = toComponent[TAIl];
					componentInfo.remove(toComponent);
				}
			}
			componentCnt--;
			if(componentCnt == 1) return log[0];
		}
		return -1;
	}
}
