package medium.Number_of_Restricted_Paths_First_to_Last_Node;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

/*
Runtime: 164 ms, faster than 57.48% of Java online submissions for Number of Restricted Paths From First to Last Node.
Memory Usage: 135.6 MB, less than 14.96% of Java online submissions for Number of Restricted Paths From First to Last Node.
Subject : dijkstra
 */
public class Solution {
  @Test
  public void execute() {
    int n = 5;
    int[][] edges = new int[][]{
        {1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}
    };
    System.out.println(countRestrictedPaths(n, edges));
  }

  private static final int NODE = 0;
  private static final int WEIGHT = 1;
  private static final long modulo = (long)(Math.pow(10, 9) + 7);

  public int countRestrictedPaths(int n, int[][] connected) {
    boolean[] visited = new boolean[n];
    Integer[] distanceToLastNode = new Integer[n];
    PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e[WEIGHT]));

    List<int[]>[] edges = new LinkedList[n];
    for(int i = 0; i < n; i++) edges[i] = new LinkedList<>();
    for(int[] edge : connected) {
      edges[edge[0] - 1].add(new int[]{edge[1] - 1, edge[2]});
      edges[edge[1] - 1].add(new int[]{edge[0] - 1, edge[2]});
    }

    pQueue.offer(new int[]{n - 1, 0});
    distanceToLastNode[n - 1] = 0;

    while(pQueue.isEmpty() == false) {
      int[] node = pQueue.poll();

      if(visited[node[NODE]] == false) {
        visited[node[NODE]] = true;

        for(int[] neighbor : edges[node[NODE]]) {
          if(distanceToLastNode[neighbor[NODE]] == null || node[WEIGHT] + neighbor[WEIGHT] < distanceToLastNode[neighbor[NODE]]) {
            distanceToLastNode[neighbor[NODE]] = node[WEIGHT] + neighbor[WEIGHT];
            pQueue.offer(new int[]{neighbor[NODE], distanceToLastNode[neighbor[NODE]]});
          }
        }
      }
    }

    Long[] memoization = new Long[n];
    return (int)DFS(0, edges, distanceToLastNode, memoization, n - 1);
  }

  private long DFS(int cur, List<int[]>[] edges, Integer[] distanceToLastNode, Long[] memoization, int target) {
    if(cur == target) {
      return 1L;
    } else if(memoization[cur] != null) {
      return memoization[cur];
    }

    Long result = 0L;
    for(int[] edge : edges[cur]) {
      if(distanceToLastNode[edge[NODE]] < distanceToLastNode[cur]) {
        result += DFS(edge[NODE], edges, distanceToLastNode, memoization, target);
      }
    }
    result /= modulo;
    memoization[cur] = result;

    return result;
  }
}
