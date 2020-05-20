package medium.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime : 14ms(50.21%)
 * Memory : 47.5mb(100.00%)
 */
public class LRUCache {
	class Node {
		public int key, value;
		public Node before, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	public Node emptyNode = new Node(0,0);

	private Map<Integer, Node> nodeMap = new HashMap<>();
	private int capacity;
	private Node first, last;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	private void linkNode(Node front, Node rear) {
		front.next = rear;
		rear.before = front;
	}

	public int get(int key) {
		Node target = nodeMap.get(key);

		if (target == null) return -1;

		if (target == first) {
			return target.value;
		} else if (target == last) {
			last = target.before;
			last.next = null;
		} else {
			linkNode(target.before, target.next);
		}

		linkNode(target, first);
		target.before = null;
		first = target;

		print();
		return target.value;
	}

	public void put(int key, int value) {
		if(nodeMap.containsKey(key)) {
			Node target = nodeMap.get(key);
			if (target == first) {
				first = first.next;
			} else if (target == last) {
				last = target.before;
				last.next = null;
			} else {
				linkNode(target.before, target.next);
			}
			nodeMap.remove(key);
		} else if (nodeMap.size() == capacity) {
			Node beforeNode = last.before;
			if (beforeNode != null) beforeNode.next = null;

			nodeMap.remove(last.key);
			last = beforeNode;
		}

		Node newNode = new Node(key, value);
		nodeMap.put(key, newNode);

		if (nodeMap.size() == 1) {
			first = last = newNode;
		} else {
			linkNode(newNode, first);
			first = newNode;
		}
		print();
	}

	public void print() {
		Node cur = first;
		while(cur != null) {
			System.out.print("(" + cur.key + " , " + cur.value + ") -> ");
			cur = cur.next;
		}
		System.out.println();
	}

	public void printInv() {
		Node cur = last;
		while(cur != null) {
			System.out.print("(" + cur.key + " , " + cur.value + ") -> ");
			cur = cur.before;
		}
		System.out.println();
	}
}
