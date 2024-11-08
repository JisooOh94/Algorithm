package medium.K_th_Smallest_Prime_Fraction;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class Solution {

  @Test
  public void execute() {
    int[] arr = new int[]{1,13,17,59};
    int[] result = kthSmallestPrimeFraction(arr, 6);
    System.out.println(result[0] + " - " + result[1]);
  }

  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    int childMax = (arr.length / 2) + arr.length % 2;
    int parentMin  = (arr.length / 2) - 1;

    boolean[][] visited = new boolean[arr.length][arr.length];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{arr.length - 1, 0});
    List<double[]> result = new LinkedList<>();

    while (queue.isEmpty() == false) {
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        int[] cur = queue.poll();
        result.add(new double[]{cur[0], cur[1], Double.valueOf(arr[cur[1]]) / Double.valueOf(arr[cur[0]])});
        if (cur[0] -1 > parentMin && visited[cur[0]-1][cur[1]] == false) {
          queue.offer(new int[]{cur[0] - 1, cur[1]});
          visited[cur[0]-1][cur[1]] = true;
        }

        if (cur[1] + 1 < childMax && visited[cur[0]][cur[1] + 1] == false) {
          queue.offer(new int[]{cur[0], cur[1] + 1});
          visited[cur[0]][cur[1] + 1] = true;
        }
      }

      if (result.size() >= k) {
        Collections.sort(result, Comparator.comparingDouble(val -> val[2]));
        int childIdx = (int) result.get(k - 1)[1];
        int parentIdx = (int) result.get(k - 1)[0];
        return new int[]{arr[childIdx], arr[parentIdx]};
      }
    }
    return null;
  }
}
