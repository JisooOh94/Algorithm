package medium.Clone_Binary_Tree_With_Random_Pointer;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Runtime : 9ms(40.30%)
 * Memory : 40.2mb(97.04%)
 */
public class Solution {
	public static class Node {
		public int val;
		public Node left, right, random;

		Node() { }
		Node(int val) { this.val = val; }
		Node(int val, Node left, Node right, Node random) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.random = random;
		}
	}

	private Node recursion(Node cur, Map<Node, Node> randomMap, Map<Node, List<Node>> standByMap) {
		if(cur == null) return null;

		Node curCpy = new Node(cur.val);
		randomMap.put(cur, curCpy);
		for(Node standByNode : standByMap.getOrDefault(cur, Collections.emptyList())) standByNode.random = curCpy;
		if(randomMap.containsKey(cur.random)) curCpy.random = randomMap.get(cur.random);
		else if(cur.random != null){
			if(!standByMap.containsKey(cur.random)) standByMap.put(cur.random, new LinkedList<>());
			standByMap.get(cur.random).add(curCpy);
		}

		curCpy.left = recursion(cur.left, randomMap, standByMap);
		curCpy.right = recursion(cur.right, randomMap, standByMap);

		return curCpy;
	}

	public Node copyRandomBinaryTree(Node root) {
		return recursion(root,new HashMap<>(), new HashMap<>());
	}
}
