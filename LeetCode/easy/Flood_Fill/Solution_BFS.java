package easy.Flood_Fill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
public class Solution_BFS {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int height = image.length;
    int width = image[0].length;

    if (height == 1 && width == 1) {
      return image;
    }

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[height][width];
    queue.offer(new int[]{sr, sc});
    visited[sr][sc] = true;
    int targetColor = image[sr][sc];

    while (queue.isEmpty() == false) {
      int length = queue.size();

      for (int i = 0; i < length; i++) {
        int[] cur = queue.poll();
        int row = cur[0], col = cur[1];
        image[row][col] = color;

        if (row - 1 >= 0 && image[row - 1][col] == targetColor && visited[row - 1][col] == false) {
          visited[row - 1][col] = true;
          queue.offer(new int[]{row - 1, col});
        }

        if (col - 1 >= 0 && image[row][col - 1] == targetColor && visited[row][col - 1] == false) {
          visited[row][col - 1] = true;
          queue.offer(new int[]{row, col - 1});
        }

        if (row + 1 < height && image[row + 1][col] == targetColor && visited[row + 1][col] == false) {
          visited[row + 1][col] = true;
          queue.offer(new int[]{row + 1, col});
        }

        if (col + 1 < width && image[row][col + 1] == targetColor && visited[row][col + 1] == false) {
          visited[row][col + 1] = true;
          queue.offer(new int[]{row, col + 1});
        }
      }
    }

    return image;
  }
}
