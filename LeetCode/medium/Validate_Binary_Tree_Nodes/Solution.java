package medium.Validate_Binary_Tree_Nodes;

public class Solution {
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] parentCnt = new int[n];
    for(int child : leftChild) if(child != -1) parentCnt[child]++;
    for(int child : rightChild) if(child != -1) parentCnt[child]++;

    Integer root = null;

    for(int i = 0; i < n; i++) {
      if(parentCnt[i] == 0) {
        if(root != null) return false;
        else root = i;
      }
      else if(parentCnt[i] == 2) return false;
    }

    if(root == null || (n > 1 && leftChild[root] == -1 && rightChild[root] == -1)) return false;

    return true;
  }
}
