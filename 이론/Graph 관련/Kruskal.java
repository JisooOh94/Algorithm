import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class Kruskal {
  @Test
  public void test() {
    int[][] edges = {
        {1, 7, 12},
        {1, 4, 28},
        {1, 2, 67},
        {1, 5, 17},
        {2, 4, 24},
        {2, 5, 62},
        {3, 5, 20},
        {3, 6, 37},
        {4, 7, 13},
        {5, 6, 45},
        {5, 7, 73}
    };

    List<int[]> minSpanningTree = kruskal(7, edges);
    minSpanningTree.stream().forEach(edge -> System.out.println(edge[0] + ", " + edge[1]));
  }

  private static final int FROM = 0;
  private static final int TO = 1;
  private static final int WEIGHT = 2;

  private int find(int cur, Integer[] group) {
    if(group[cur] == null) {
      return cur;
    }
    group[cur] = find(group[cur], group);
    return group[cur];
  }

  private void union(int from, int to, Integer[] group, int[] rank) {
    if(rank[from] < rank[to]) group[from] = to;
    else if(rank[to] < rank[from]) group[to] = from;
    else {
      group[from] = to;
      rank[to]++;
    }
  }

  public List<int[]> kruskal(int n, int[][] edges) {
    Integer[] group = new Integer[n];
    int[] rank = new int[n];
    List<int[]> minSpanningTree = new LinkedList<>();
    Arrays.sort(edges, Comparator.comparingInt(e -> e[WEIGHT]));
    for(int[] edge : edges) {
      int fromGroup = find(edge[FROM] - 1, group);
      int toGroup = find(edge[TO] - 1, group);

      if(fromGroup != toGroup) {
        minSpanningTree.add(edge);
        union(fromGroup, toGroup, group, rank);
        if(minSpanningTree.size() == n) break;
      }
    }

    return minSpanningTree.size() == n -1 ? minSpanningTree : null;
  }
}
