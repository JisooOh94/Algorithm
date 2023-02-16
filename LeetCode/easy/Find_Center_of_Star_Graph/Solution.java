package easy.Find_Center_of_Star_Graph;

import org.junit.Test;

/**
 * Time Complexity : O(1)
 */
public class Solution {
  @Test
  public void execute() {
    int[][] edges = new int[][]{
        {1, 2},
        {5, 1}
    };
    System.out.println(findCenter(edges));
  }
  public int findCenter(int[][] edges) {
    return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
  }
}
