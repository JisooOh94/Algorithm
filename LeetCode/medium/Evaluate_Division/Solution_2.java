package medium.Evaluate_Division;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class Solution_2 {
  public double[] calcEquation(List<List<String>> e, double[] values, List<List<String>> q) {
    String[][] equations = new String[e.size()][2];
    String[][] query = new String[q.size()][2];

    for (int i = 0; i < e.size(); i++) {
      equations[i] = new String[]{e.get(i).get(0), e.get(i).get(1)};
    }

    for (int i = 0; i < q.size(); i++) {
      query[i] = new String[]{q.get(i).get(0), q.get(i).get(1)};
    }

    // map string to integer
    Map<String, Integer> mIdTable = new HashMap<>();
    int len = 0;
    for (String[] words : equations) {
      for (String word : words) {
        if (!mIdTable.containsKey(word)) {
          mIdTable.put(word, len++);
        }
      }
    }

    // init parent index and value
    Node[] nodes = new Node[len];
    for (int i = 0; i < len; ++i) {
      nodes[i] = new Node(i);
    }

    // union, you can take an example as follows
    // (a/b=3)->(c/d=6)->(b/d=12)
    for (int i = 0; i < equations.length; ++i) {
      String[] keys = equations[i];
      int k1 = mIdTable.get(keys[0]);
      int k2 = mIdTable.get(keys[1]);
      int groupHead1 = find(nodes, k1);
      int groupHead2 = find(nodes, k2);
      nodes[groupHead2].parent = groupHead1;
      nodes[groupHead2].value = nodes[k1].value * values[i] / nodes[k2].value;
    }

    // query now
    double[] result = new double[query.length];
    for (int i = 0; i < query.length; ++i) {
      Integer k1 = mIdTable.get(query[i][0]);
      Integer k2 = mIdTable.get(query[i][1]);
      if (k1 == null || k2 == null) {
        result[i] = -1d;
      } else {
        int groupHead1 = find(nodes, k1);
        int groupHead2 = find(nodes, k2);
        if (groupHead1 != groupHead2) {
          result[i] = -1d;
        } else {
          result[i] = nodes[k2].value / nodes[k1].value;
        }
      }
    }
    return result;
  }

  public int find(Node[] nodes, int k) {
    int p = k;
    while (nodes[p].parent != p) {
      p = nodes[p].parent;
      // compress
      nodes[k].value *= nodes[p].value;
    }
    // compress
    nodes[k].parent = p;
    return p;
  }

  private static class Node {

    int parent;
    double value;

    public Node(int index) {
      this.parent = index;
      this.value = 1d;
    }
  }
}
