package medium.Find_Distance_in_a_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 231ms(5.69%)
 * Memory : 52mb(7.72%)
 */
public class Solution {
	@Test
	public void execute() {

	}
	int p, q;
	boolean foundP, foundQ = false;
	private List<Integer> pPath;
	private List<Integer> qPath;

	private void recursion(TreeNode cur, LinkedList<Integer> path) {
		if(foundP && foundQ) return;
		else if(cur == null) return;

		path.addLast(cur.val);
		if(!foundP && cur.val == p) {
			foundP = true;
			pPath = new ArrayList<>(path);
		} else if(!foundQ && cur.val == q) {
			foundQ = true;
			qPath = new ArrayList<>(path);
		}

		recursion(cur.left, path);
		recursion(cur.right, path);

		path.removeLast();
	}

	public int findDistance(TreeNode root, int p, int q) {
		if(p == q) return 0;

		LinkedList<Integer> path = new LinkedList<>();
		this.p = p;
		this.q = q;

		recursion(root, path);

		List<Integer> target = pPath.size() < qPath.size() ? pPath : qPath;
		List<Integer> source = pPath.size() < qPath.size() ? qPath : pPath;

		for(int i = 1; i < source.size(); i++) {
			int parent = source.get(source.size() - i - 1);
			if(target.contains(parent)) {
				return (target.size() - target.indexOf(parent) - 1) + i;
			}
		}
		return 0;
	}
}
