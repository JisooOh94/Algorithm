package medium.All_Possible_Full_Binary_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import util.TreeNode;

public class Soluction {

  @Test
  public void execution() {
    int n = 7;
    List<TreeNode> result = allPossibleFBT(n);
  }

  public List<TreeNode> recursion(int leftNodeCnt, List<TreeNode>[] record) {
    if (leftNodeCnt == 0 || leftNodeCnt == 1) return new ArrayList(Arrays.asList(new TreeNode(0)));

    leftNodeCnt -= 2;

    if (record[leftNodeCnt] != null) return record[leftNodeCnt];

    List<TreeNode> treeNodeList = new LinkedList<>();
    for (int i = 0; i <= leftNodeCnt; i += 2) {
      List<TreeNode> leftChildNodes = recursion(i, record);
      List<TreeNode> rightChildNodes = recursion(leftNodeCnt - i, record);

      for (int leftChildIdx = 0; leftChildIdx < leftChildNodes.size(); leftChildIdx++) {
        for (int rightChildIdx = 0; rightChildIdx < rightChildNodes.size(); rightChildIdx++) {
          TreeNode parent = new TreeNode(0);
          parent.left = leftChildNodes.get(leftChildIdx);
          parent.right = rightChildNodes.get(rightChildIdx);
          treeNodeList.add(parent);
        }
      }
    }

    record[leftNodeCnt] = treeNodeList;

    return treeNodeList;
  }

  public List<TreeNode> allPossibleFBT(int n) {
    if (n % 2 != 1) return Collections.emptyList();
    List<TreeNode>[] record = new List[n + 1];
    return recursion(n, record);
  }
}
