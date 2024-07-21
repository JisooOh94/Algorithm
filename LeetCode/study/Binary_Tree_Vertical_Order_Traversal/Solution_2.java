package study.Binary_Tree_Vertical_Order_Traversal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import org.junit.Test;
import sun.awt.image.ImageWatched.Link;
import util.TreeNode;

public class Solution_2 {

  @Test
  public void execute() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(0);
    root.left.right.left = new TreeNode(5);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(1);
    root.right.left.right = new TreeNode(2);
    root.right.right = new TreeNode(7);
    List<List<Integer>> result = verticalOrder(root);
    int a = 0;
  }
  private void recursion(TreeNode cur, int depth, Map<Integer, List<Integer>> verticalOrderedNodes) {
    if (cur == null) return;
    List<Integer> depthNodes = verticalOrderedNodes.get(depth);
    if (depthNodes == null) {
      depthNodes = new LinkedList<>();
      verticalOrderedNodes.put(depth, depthNodes);
    }
    depthNodes.add(cur.val);

    recursion(cur.left, depth - 1, verticalOrderedNodes);
    recursion(cur.right, depth + 1, verticalOrderedNodes);
  }

  public List<List<Integer>> verticalOrder(TreeNode root) {
    Map<Integer, List<Integer>> verticalOrderedNodes = new HashMap<>();
    Queue<Integer> depthQueue = new LinkedList<>();
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    depthQueue.offer(0);
    nodeQueue.offer(root);

    int minDepth = Integer.MAX_VALUE;
    int maxDepth = Integer.MIN_VALUE;

    while (nodeQueue.isEmpty() == false) {
      int curDepth = depthQueue.poll();
      TreeNode curNode = nodeQueue.poll();

      minDepth = Math.min(minDepth, curDepth);
      maxDepth = Math.max(maxDepth, curDepth);

      List<Integer> depthNodes = verticalOrderedNodes.get(curDepth);
      if (depthNodes == null) {
        depthNodes = new LinkedList<>();
        verticalOrderedNodes.put(curDepth, depthNodes);
      }

      depthNodes.add(curNode.val);

      if (curNode.left != null) {
        depthQueue.offer(curDepth - 1);
        nodeQueue.offer(curNode.left);
      }

      if (curNode.right != null) {
        depthQueue.offer(curDepth + 1);
        nodeQueue.offer(curNode.right);
      }
    }

    List<List<Integer>> resultList = new LinkedList<>();
    for (int i = minDepth; i <= maxDepth; i++) {
      resultList.add(verticalOrderedNodes.get(i));
    }

    return resultList;
  }
}
