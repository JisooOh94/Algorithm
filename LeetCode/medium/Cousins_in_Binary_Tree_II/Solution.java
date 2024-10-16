package medium.Cousins_in_Binary_Tree_II;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import util.TreeNode;

/**
 * Topic : BFS
 * Runtime : 15ms (89.60%)
 * Memory : 77.83mb (56.38%)
 */
public class Solution {
  @Test
  public void execute() {
    TreeNode root = new TreeNode(5);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(9);

    root.left = left;
    root.right = right;

    replaceValueInTree(root);
  }
  public TreeNode replaceValueInTree(TreeNode root) {
    if (root.left == null && root.right == null) {
      root.val = 0;
      return root;
    }

    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.offer(new TreeNode[]{root});
    int depthNodesSum = 0;

    while(queue.isEmpty() == false) {
      int len = queue.size();
      int childDepthNodesSum = 0;
      for (int i = 0; i < len; i++) {
        TreeNode[] pair = queue.poll();
        if (pair.length == 2) {
          int curNodesVal = depthNodesSum - (pair[0].val + pair[1].val);
          pair[0].val = pair[1].val = curNodesVal > 0 ? curNodesVal : 0;
          childDepthNodesSum += next(pair[0], queue);
          childDepthNodesSum += next(pair[1], queue);
        } else {
          int curNodesVal = depthNodesSum - pair[0].val;
          pair[0].val = curNodesVal > 0 ? curNodesVal : 0;
          childDepthNodesSum += next(pair[0], queue);
        }
      }
      depthNodesSum = childDepthNodesSum;
    }
    return root;
  }

  private int next(TreeNode parent, Queue<TreeNode[]> queue) {
    if (parent.left != null && parent.right != null) {
      queue.offer(new TreeNode[]{parent.left, parent.right});
      return parent.left.val + parent.right.val;
    } else if (parent.left != null) {
      queue.offer(new TreeNode[]{parent.left});
      return parent.left.val;
    } else if (parent.right != null) {
      queue.offer(new TreeNode[]{parent.right});
      return parent.right.val;
    }
    return 0;
  }

}
