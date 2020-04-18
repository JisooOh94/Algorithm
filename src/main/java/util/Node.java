package util;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public int val;
	public Node next;
	public Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	public static Node makeList(Integer... args) {
		List<Node> list = new ArrayList<>(args.length / 2);
		for (int i = 0; i < args.length / 2; i++) {
			list.add(new Node(args[i * 2]));
		}

		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).next = list.get(i + 1);
		}

		for (int i = 0; i < list.size(); i++) {
			if(args[2 * i + 1] != null) {
				list.get(i).random = list.get(args[2 * i + 1]);
			}
		}

		return list.get(0);
	}
}