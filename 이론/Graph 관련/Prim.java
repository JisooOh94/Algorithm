import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class Prim {
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

    List<int[]> minSpanningTree = prim(7, edges);
    minSpanningTree.stream().forEach(edge -> System.out.println(edge[0] + ", " + edge[1]));
  }

  private static final int FROM = 0;
  private static final int TO = 1;
  private static final int WEIGHT = 2;
  private static final int INITIAL_NODE = 0;

  public List<int[]> prim(int n, int[][] edges) {
    List<int[]> minSpanningTree = new LinkedList<>();

    List<int[]>[] nodeEdges = new LinkedList[n];
    for(int i = 0; i < n; i++) {
      nodeEdges[i] = new LinkedList<>();
    }
    for(int[] edge : edges) {
      nodeEdges[edge[0] - 1].add(new int[]{edge[0], edge[1], edge[2]});
      nodeEdges[edge[1] - 1].add(new int[]{edge[1], edge[0], edge[2]});
    }

    boolean[] isIncludedMst = new boolean[n];
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e[WEIGHT]));

    isIncludedMst[INITIAL_NODE] = true;
    priorityQueue.addAll(nodeEdges[INITIAL_NODE]);

    while(priorityQueue.isEmpty() == false) {
      int[] minWeightEdge  = priorityQueue.poll();
      int destNode = minWeightEdge[TO] - 1;
      if(isIncludedMst[destNode] == false) {
        isIncludedMst[destNode] = true;
        minSpanningTree.add(minWeightEdge);
        priorityQueue.addAll(nodeEdges[destNode]);

        if(minSpanningTree.size() == n - 1) break;
      }
    }

    return minSpanningTree;
  }
}
