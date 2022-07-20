package medium.Validate_Binary_Tree_Nodes;
/**
 * Runtime: 3 ms(97.90%)
 * Memory Usage: 43.5 MB(94.01%)
 * Time Complexity : O(n^2)
 **/
public class Solution_2 {
  private int find(int cur, int[] group) {
    if(group[cur] == cur) return cur;

    group[cur] = find(group[cur], group);
    return group[cur];
  }

  private boolean union(int parent, int child, int[] group) {
    //check overlapped child
    if(group[child] != child) return false;

    int parentGroup = find(parent, group);
    int childGroup = find(child, group);

    //check cycle
    if(parentGroup == childGroup) return false;

    group[childGroup] = parentGroup;

    return true;
  }
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] groups = new int[n];
    for(int i = 0; i < n; i++) groups[i] = i;
    for(int i = 0; i < n; i++) {
      if(leftChild[i] != -1)
        if(union(i, leftChild[i], groups) == false) return false;
      if(rightChild[i] != -1)
        if(union(i, rightChild[i], groups) == false) return false;
    }

    int oneGroupCheck = -1;

    for(int group : groups) {
      int curGroup = find(group, groups);
      if(oneGroupCheck != -1 && curGroup != oneGroupCheck) return false;
      oneGroupCheck = curGroup;
    }
    return true;
  }
}
