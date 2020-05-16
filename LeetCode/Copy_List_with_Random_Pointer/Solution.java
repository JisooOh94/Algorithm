package Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

import util.Node;
import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39mb(5.61%)
 */
public class Solution implements Predicate<Node, Object> {
	public Node test(Object... params) {
		Node headCopy = copyRandomList((Node)params[0]);

		Node cur = headCopy;
		while(cur != null) {
			Node rand = cur.random;

			System.out.print(cur.val + " / ");
			System.out.println(rand != null ? rand.val : "NULL");

			cur = cur.next;
		}

		return headCopy;
	}

	public Node copyRandomList(Node head) {
		if(head == null) {
			return head;
		} else if(head.next == null) {
			Node copy = new Node(head.val);
			copy.random = head.random != null ? copy : null;
			return copy;
		}

		Map<Node, Node> nodeMap = new HashMap<>();

		Node headCopy = new Node(0);
		nodeMap.put(head, headCopy);

		Node cur = head;
		while(cur != null) {
			Node next = cur.next;
			Node rand = cur.random;

			Node curCopy = nodeMap.get(cur);
			curCopy.val = cur.val;

			if(next != null) {
				if (!nodeMap.containsKey(next)) {
					nodeMap.put(next, new Node(0));
				}

				Node nextCopy = nodeMap.get(next);
				curCopy.next = nextCopy;
			}

			if(rand != null) {
				if(!nodeMap.containsKey(rand)) {
					nodeMap.put(rand, new Node(0));
				}

				Node randCopy = nodeMap.get(rand);
				curCopy.random = randCopy;
			}

			cur = cur.next;
		}

		return nodeMap.get(head);
	}
}
