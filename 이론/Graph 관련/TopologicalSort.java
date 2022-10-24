package medium.ZigZag_Conversion;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import sun.awt.image.ImageWatched.Link;

public class TopologicalSort {
  @Test
  public void test() {
    int[][] edges = {
        {3, 0},
        {3, 4},
        {0, 1},
        {4, 1},
        {4, 2},
        {1, 2},
        {2, 5}
    };
    List<Integer> result = topologicalSort(6, edges);
    result.stream().forEach(System.out::println);
  }
  private static final int FROM = 0;
  private static final int TO = 1;
  private List<Integer> topologicalSort(int n, int[][] edges) {
    List<Integer>[] graph = new LinkedList[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new LinkedList<>();
    }

    int[] incomingEdges = new int[n];
    for(int [] edge : edges) {
      graph[edge[FROM]].add(edge[TO]);
      incomingEdges[edge[TO]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < incomingEdges.length; i++) {
      if (incomingEdges[i] == 0) {
        queue.offer(i);
      }
    }

    List<Integer> order = new LinkedList<>();
    while(!queue.isEmpty()) {
      int node = queue.poll();
      order.add(node);

      for(int connectedNodes : graph[node]) {
        incomingEdges[connectedNodes]--;
        if(incomingEdges[connectedNodes] == 0) {
          queue.offer(connectedNodes);
        }
      }
    }

    if(order.size() != n) {
      throw new InvalidParameterException("Graph is DAG");
    }

    return order;
  }
}
