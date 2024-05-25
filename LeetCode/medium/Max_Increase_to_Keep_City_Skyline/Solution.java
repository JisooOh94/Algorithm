package medium.Max_Increase_to_Keep_City_Skyline;

import java.util.Map;
import org.junit.Test;

/**
 * Runtime : 1ms(45.45%)
 * Memory : 43.84(84.05%)
 * Time Complexity : O(n)
 */
public class Solution {
  @Test
  public void execute() {
    int[][] grid = new int[][]{
        {3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}
    };

    System.out.println(maxIncreaseKeepingSkyline(grid));
  }
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] rowMax = new int[grid.length];
    int[] colMax = new int[grid.length];

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid.length; col++) {
        rowMax[row] = Math.max(rowMax[row], grid[row][col]);
        colMax[col] = Math.max(colMax[col], grid[row][col]);
      }
    }

    int increased = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid.length; col++) {
        increased += Math.min(rowMax[row], colMax[col]) - grid[row][col];
      }
    }

    return increased;
  }
}
