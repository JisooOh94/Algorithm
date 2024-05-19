package medium.Balance_a_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.TreeNode;

/**
 * Runtime : 8 ms (7.28%)
 * Memory : 45.56mb (78.35%)
 * Time Complexity: O(nlogn)
 */
public class Solution {

  private void traverse(TreeNode cur, List<Integer> values) {
    if (cur != null) values.add(cur.val);

    if (cur.left != null) {
      traverse(cur.left, values);
    }
    if (cur.right != null) {
      traverse(cur.right, values);
    }
  }

  private TreeNode makeTree(int left, int right, List<Integer> values) {
    if (right <= left) return null;

    int mid = left + (right - left) / 2;
    TreeNode cur = new TreeNode(values.get(mid));

    cur.left = makeTree(left, mid, values);
    cur.right = makeTree(mid + 1, right, values);

    return cur;
  }

  public TreeNode balanceBST(TreeNode root) {
    List<Integer> values = new ArrayList<>();

    traverse(root, values);
    Collections.sort(values);

    TreeNode newRoot = makeTree(0, values.size(), values);

    return newRoot;
  }
}
