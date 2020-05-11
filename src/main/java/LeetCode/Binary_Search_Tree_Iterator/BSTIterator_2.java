package LeetCode.Binary_Search_Tree_Iterator;

import util.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 15ms(91.30%)
 * Memory : 44.5mb(100.0%)
 */
public class BSTIterator_2 {
    private Queue<Integer> valQ;
    private Iterator<Integer> iter;

    private void recursion(TreeNode node, Queue<Integer> queue) {
        if (node.left != null) recursion(node.left, queue);
        queue.offer(node.val);
        if (node.right != null) recursion(node.right, queue);
    }

    public BSTIterator_2(TreeNode root) {
        valQ = new LinkedList<>();
        if (root != null) recursion(root, valQ);
        iter = valQ.iterator();
    }

    public int next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}
