package LeetCode.Binary_Search_Tree_Iterator;

import util.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 14ms(99.87%)
 * Memory : 44.5mb(100.0%)
 */
public class BSTIterator_3 {
    private int[] valArr;
    private int idx = 0;
    private int size = 0;

    private void recursion(TreeNode node) {
        size++;
        if (node.left != null) recursion(node.left);
        valArr[idx++] = node.val;
        if (node.right != null) recursion(node.right);
    }

    public BSTIterator_3(TreeNode root) {
        valArr = new int[100000000];
        if (root != null) {
            recursion(root);
            idx = 0;
        }
    }

    public int next() {
        return valArr[idx++];
    }

    public boolean hasNext() {
        return size != 0 && idx < size;
    }
}
