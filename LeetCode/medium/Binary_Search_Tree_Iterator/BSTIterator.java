package medium.Binary_Search_Tree_Iterator;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 15ms(91.30%)
 * Memory : 44.3mb(100.0%)
 */
public class BSTIterator {
    private Queue<Integer> valQ;

    private void recursion(TreeNode node, Queue<Integer> queue) {
        if(node.left != null) recursion(node.left, queue);
        queue.offer(node.val);
        if(node.right != null) recursion(node.right, queue);
    }

    public BSTIterator(TreeNode root) {
        valQ = new LinkedList<>();
        if(root != null) recursion(root, valQ);
    }

    public int next() {
        return valQ.poll();
    }

    public boolean hasNext() {
        return valQ.isEmpty();
    }
}
