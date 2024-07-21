package study.Binary_Tree_Vertical_Order_Traversal;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 7ms(6.56%)
 * Memory : 39.2mb(73.77%)
 */
public class Solution {
	@Test
	public void execute() {

	}
	private void recursion(TreeNode cur, int level, Map<Integer, List<Integer>> map) {
		List<Integer> curList = map.get(level);
		if(curList == null) map.put(level, new LinkedList<>(Arrays.asList(cur.val)));
		else curList.add(cur.val);

		if(cur.left != null) recursion(cur.left, level - 1, map);
		if(cur.right != null) recursion(cur.right, level + 1, map);
	}
	public List<List<Integer>> verticalOrder(TreeNode root) {
		if(root == null) return Collections.emptyList();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Object[]> queue = new LinkedList<>();
		queue.offer(new Object[]{root, 0});

		while(!queue.isEmpty()) {
			Object[] info = queue.poll();
			TreeNode cur = (TreeNode)info[0];
			Integer level = (Integer)info[1];

			List<Integer> curList = map.get(level);
			if(curList == null) map.put(level, new LinkedList<>(Arrays.asList(cur.val)));
			else curList.add(cur.val);

			if(cur.left != null) queue.offer(new Object[]{cur.left, level - 1});
			if(cur.right != null) queue.offer(new Object[]{cur.right, level + 1});
		}

		return map.entrySet().stream().collect(Collectors.toList()).stream().sorted((e1, e2) -> e1.getKey() > e2.getKey() ? 1 : e1.getKey() < e2.getKey() ? -1 : 0).map(e -> e.getValue()).collect(Collectors.toList());
	}
}
