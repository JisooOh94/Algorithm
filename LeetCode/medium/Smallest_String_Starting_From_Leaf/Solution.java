package medium.Smallest_String_Starting_From_Leaf;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 11ms(17.86%
 * Memory : 39.7mb(16.43%)
 */
public class Solution {
	@Test
	public void execute() {
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.offer("bca");
		queue.offer("b");
		queue.offer("bc");

		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	private void recursion(TreeNode cur, LinkedList<Character> list, PriorityQueue<String> queue) {
		list.addFirst((char)(cur.val + 'a'));

		if(cur.left == null && cur.right == null) {
			queue.offer(list.stream().map(String::valueOf).collect(Collectors.joining()));
		} else {
			if(cur.left != null) recursion(cur.left, list, queue);
			if(cur.right != null) recursion(cur.right, list, queue);
		}

		list.removeFirst();
	}

	public String smallestFromLeaf(TreeNode root) {
		PriorityQueue<String> queue = new PriorityQueue<>();
		LinkedList<Character> list = new LinkedList<>();

		recursion(root, list, queue);
		return queue.poll();
	}
}
