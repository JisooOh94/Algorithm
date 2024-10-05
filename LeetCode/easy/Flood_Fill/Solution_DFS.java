package easy.Flood_Fill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS
 * Runtime : 0ms(100%)
 * Memory : 44.48 mb(91.07%)
 */
public class Solution_DFS {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {

    int height = image.length;
    int width = image[0].length;

    if (height == 1 && width == 1) {
      return image;
    }

    fill(image, new boolean[height][width], sr, sc, height, width, image[sr][sc], color);
    return image;
  }

  private void fill(int[][] image, boolean[][] visited, int row, int col, int height, int width, int targetColor, int fillColor) {
    image[row][col] = fillColor;
    visited[row][col] = true;

    if (row - 1 >= 0 && image[row -1][col] == targetColor && visited[row - 1][col] == false) {
      fill(image, visited, row - 1, col, height, width, targetColor, fillColor);
    }

    if (col - 1 >= 0 && image[row][col - 1] == targetColor && visited[row][col - 1] == false) {
      fill(image, visited, row, col - 1, height, width, targetColor, fillColor);
    }

    if (row + 1 < height && image[row + 1][col] == targetColor && visited[row + 1][col] == false) {
      fill(image, visited, row + 1, col, height, width, targetColor, fillColor);
    }

    if (col + 1 < width && image[row][col + 1] == targetColor && visited[row][col + 1] == false) {
      fill(image, visited, row, col + 1, height, width, targetColor, fillColor);
    }
  }
}
