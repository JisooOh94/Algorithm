package medium.Binary_Tree_Vertical_Order_Traversal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import util.TreeNode;

public class Solution_1 {

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
    Map<Integer, List<Integer>> verticalOrderedNodes = new TreeMap<>(Comparator.comparingInt(val -> val));
    recursion(root, 0, verticalOrderedNodes);
    return new ArrayList<>(verticalOrderedNodes.values());
  }
}
