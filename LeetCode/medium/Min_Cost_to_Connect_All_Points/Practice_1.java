package medium.Min_Cost_to_Connect_All_Points;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Subject : Kruskal
 */
public class Practice_1 {
  private static final int FROM = 0;
  private static final int TO = 1;
  private static final int DIST = 2;

  private int getDistance(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }

  private int find(int cur, Integer[] parent) {
    if(parent[cur] == null) {
      return cur;
    }
    parent[cur] = find(parent[cur], parent);
    return parent[cur];
  }

  public int minCostConnectPoints(int[][] points) {
    PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
    for(int i = 0; i < points.length - 1; i++) {
      for(int j = i + 1; j < points.length; j++) {
        edges.add(new int[]{i, j, getDistance(points[i], points[j])});
      }
    }

    Integer[] parent = new Integer[points.length];
    int[] rank = new int[points.length];

    int minDist = 0;
    int edgeCnt = 0;

    while(!edges.isEmpty()) {
      int[] edge = edges.poll();
      int fromParent = find(edge[FROM], parent);
      int toParent = find(edge[TO], parent);

      if(fromParent != toParent) {
        minDist += edge[DIST];
        if(++edgeCnt == parent.length - 1) break;

        if(rank[fromParent] < rank[toParent]) {
          parent[fromParent] = toParent;
        } else if(rank[toParent] < rank[fromParent]) {
          parent[toParent] = fromParent;
        } else {
          parent[fromParent] = toParent;
          rank[toParent]++;
        }
      }
    }
    return minDist;
  }
}
