package LeetCode.Binary_Search_Tree_Iterator;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime : 14ms(99.87%)
 * Memory : 44.2mb(100.0%)
 */
public class BSTIterator_4 {
    private List<Integer> valList;
    private int idx = 0;

    private void recursion(TreeNode node) {
        if(node == null) return;

        recursion(node.left);
        valList.add(node.val);
        recursion(node.right);
    }

    public BSTIterator_4(TreeNode root) {
        valList = new ArrayList<>();
        if (root != null) {
            recursion(root);
        }
    }

    public int next() {
        return valList.get(idx++);
    }

    public boolean hasNext() {
        return valList.size() != 0 && idx < valList.size();
    }
}
