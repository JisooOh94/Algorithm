package medium.Count_the_Number_of_Complete_Components;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import sun.awt.image.ImageWatched.Link;

/**
 * Runtime : 12ms (53%)
 * Memory : 45.20 (34%)
 */
public class Solution {


  @Test
  public void execute() {
//    int n = 6;
//    int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
    int n = 3;
    int[][] edges = {{2,0}, {2,1}};

    int result = countCompleteComponents(n, edges);
    int a = 0;
  }

  public int countCompleteComponents(int n, int[][] e) {
    boolean[] visited = new boolean[n];
    List<Integer>[] edges = new LinkedList[n];
    for (int[] edge : e) {
      int from = edge[0];
      int to = edge[1];

      if (edges[from] == null) edges[from] = new LinkedList<>();
      edges[from].add(to);

      if (edges[to] == null) edges[to] = new LinkedList<>();
      edges[to].add(from);
    }

    int connectedComponetCnt = 0;

    for (int i = 0; i < n; i++) {
      if (visited[i]) continue;

      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i);

      int vertCnt = 0;
      int edgeCnt = 0;

      while (queue.isEmpty() == false) {
        int cur = queue.poll();
        if (visited[cur]) continue;
        vertCnt++;
        visited[cur] = true;
        if (edges[cur] != null) {
          for (int neighbor : edges[cur]) {
            if (visited[neighbor])
              continue;
            edgeCnt++;
            queue.offer(neighbor);
          }
        }
      }

      if (edgeCnt == vertCnt * (vertCnt - 1) / 2) connectedComponetCnt++;
    }

    return connectedComponetCnt;
  }
}
