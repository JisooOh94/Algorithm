import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class Dijkstra {

  @Test
  public void execute() {
    int[][] edges = {
        {0,1,2},
        {0,3,1},
        {0,2,5},
        {1,3,2},
        {1,2,3},
        {2,3,3},
        {2,4,1},
        {2,5,5},
        {3,4,1},
        {4,5,2}
    };

    for(int i = 1; i < 6; i++) {
      System.out.println(dijkstra(0, i, 6, edges));
    }
  }

  private static final int NODE = 0;
  private static final int WEIGHT = 1;

  private int dijkstra(int from, int to, int n, int[][] connected) {
    Integer[] minCost = new Integer[n];
    boolean[] visited = new boolean[n];
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));

    List<int[]>[] edges = new LinkedList[n];
    for(int i = 0; i < n; i++) {
      edges[i] = new LinkedList<>();
    }
    for(int[] edge : connected) {
      edges[edge[0]].add(new int[]{edge[1], edge[2]});
      edges[edge[1]].add(new int[]{edge[0], edge[2]});
    }

    minCost[from] = 0;
    queue.offer(new int[]{from, 0});

    while(queue.isEmpty() == false) {
      int[] node = queue.poll();
      if(node[NODE] == to) {
        break;
      }

      if(visited[node[NODE]] == false) {
        visited[node[NODE]] = true;

        for(int[] neighbor : edges[node[NODE]]) {
          if(minCost[neighbor[NODE]] == null || node[WEIGHT] + neighbor[WEIGHT] < minCost[neighbor[NODE]]) {
            minCost[neighbor[NODE]] = node[WEIGHT] + neighbor[WEIGHT];
            queue.offer(new int[]{neighbor[NODE], node[WEIGHT] + neighbor[WEIGHT]});
          }
        }
      }
    }
    return minCost[to];
  }
}
