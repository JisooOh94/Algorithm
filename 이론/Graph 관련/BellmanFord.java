import java.util.Arrays;

public class BellmanFord {
  private static int FROM = 0;
  private static int TO = 1;
  private static int WEIGHT = 2;
  public int bellmanFord(int from, int to, int n, int[][] connected) {
    int[] minCost = new int[n];
    Arrays.fill(minCost, Integer.MAX_VALUE);

    minCost[from] = 0;
    for(int i = 0; i <= n; i++) {
      for(int j = 0; j < connected.length; j++) {
        if(minCost[FROM] == Integer.MAX_VALUE) continue;

        if(minCost[FROM] + minCost[WEIGHT] < minCost[TO]) {
          if(i == n) return -1;
        }
        minCost[TO] = minCost[FROM] + minCost[WEIGHT];
      }
    }
    return minCost[TO];
  }
}
