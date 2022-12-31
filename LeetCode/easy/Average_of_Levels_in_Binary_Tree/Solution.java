package easy.Average_of_Levels_in_Binary_Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

/**
 * Runtime : 2ms(96.59%)
 * Memory : 43.7mb(83.46%)
 * Time Complexity : O(n)
 * Subject : BFS
 */
public class Solution {
  @Test
  public void test() {
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
    averageOfLevels(root).forEach(System.out::println);
  }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> avrs = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int nodeCnt = 1;

    while(!queue.isEmpty()) {
      long sum = 0;
      int childNodeCnt = 0;
      for(int i = 0; i < nodeCnt; i++) {
        TreeNode cur = queue.poll();
        sum += cur.val;

        if(cur.left != null) {
          queue.offer(cur.left);
          childNodeCnt++;
        }

        if(cur.right != null) {
          queue.offer(cur.right);
          childNodeCnt++;
        }
      }

      avrs.add(((double)sum / (double)nodeCnt));
      nodeCnt = childNodeCnt;
    }
    return avrs;
  }
}
