package medium.Count_Sub_Islands;

import org.junit.Test;

/**
 * Runtime: 47 ms, faster than 24.90% of Java online submissions for Count Sub Islands.
 * Memory Usage: 75.5 MB, less than 88.42% of Java online submissions for Count Sub Islands.
 * Subject : union-find
 * Time Complexity : O()
 */
public class Solution {
  @Test
  public void execute() {
    int[][] grid1 = new int[][]{
        {1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}
    };
    int[][] grid2 = new int[][]{
        {1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}
    };

    System.out.println(countSubIslands(grid1, grid2));
  }
  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int height = grid1.length;
    int width = grid1[0].length;

    Integer[] parent = new Integer[height * width];
    boolean[] connected = new boolean[height * width];

    for(int y = 0; y < height; y++) {
      for(int x = 0; x < width; x++) {
        if(grid2[y][x] == 1) {
          int curPos = y * width + x;
          if(parent[curPos] == null) connected[curPos] = true;
          if(y - 1  >= 0 && grid2[y - 1][x] == 1) union(curPos - width, curPos, parent, connected);
          if(y + 1  < height && grid2[y + 1][x] == 1) union(curPos, curPos + width, parent, connected);
          if(x - 1  >= 0 && grid2[y][x - 1] == 1) union(curPos - 1, curPos, parent, connected);
          if(x + 1  < width && grid2[y][x + 1] == 1) union(curPos, curPos + 1, parent, connected);
        }
      }
    }

    for(int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if(grid1[y][x] == 0 && grid2[y][x] == 1) {
          int curPos = y * width + x;
          int parentIdx = find(curPos, parent);
          connected[parentIdx] = false;
        }
      }
    }

    int subIslandsCnt = 0;
    for(int i = 0; i < connected.length; i++) {
      if(connected[i]) subIslandsCnt++;
    }
    return subIslandsCnt;
  }

  private void union(int from, int to, Integer[] parent, boolean[] connected) {
    int fromP = find(from, parent);
    int toP = find(to, parent);

    if(fromP != toP) {
      parent[toP] = fromP;
      connected[toP] = false;
      connected[fromP] = true;
    }
  }

  private int find(int cur, Integer[] parent) {
    if(parent[cur] == null) return cur;
    parent[cur] = find(parent[cur], parent);
    return parent[cur];
  }
}
