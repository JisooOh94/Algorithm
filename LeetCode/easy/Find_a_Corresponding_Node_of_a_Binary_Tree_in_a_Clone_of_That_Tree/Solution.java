package easy.Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree;

import apple.laf.JRSUIUtils.Tree;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import util.TreeNode;

class Solution {
  /**
   * BFS
   * Runtime : 10ms(?)
   * Memory : 48.63mb(95.40%)
   */
  public final TreeNode getTargetCopy_BFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (original.left == null && original.right == null) {
      return cloned;
    }
    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.offer(new TreeNode[]{original, cloned});

    while(queue != null) {
      int length = queue.size();
      for (int i = 0; i < length; i++) {
        TreeNode[] cur = queue.poll();
        if (cur[0] == target) {
          return cur[1];
        } else {
          if (cur[0].left != null) {
            queue.offer(new TreeNode[]{cur[0].left, cur[1].left});
          }

          if (cur[0].right != null) {
            queue.offer(new TreeNode[]{cur[0].right, cur[1].right});
          }
        }
      }
    }
    return null;
  }

  /**
   * DFS
   * Runtime : 0ms(100&)
   * Memory : 48.63mb(95.40%)
   */
  public final TreeNode getTargetCopy_DFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (original.left == null && original.right == null) {
      return cloned;
    }

    return find(original, cloned, target);
  }

  private TreeNode find(TreeNode cur, TreeNode curCloned, TreeNode target) {
    if (cur == target) {
      return curCloned;
    }

    if (cur.left != null) {
      TreeNode result = find(cur.left, curCloned.left, target);
      if (result != null) {
        return result;
      }
    }

    if (cur.right != null) {
      TreeNode result = find(cur.right, curCloned.right, target);
      if (result != null) {
        return result;
      }
    }
    return null;
  }
}
