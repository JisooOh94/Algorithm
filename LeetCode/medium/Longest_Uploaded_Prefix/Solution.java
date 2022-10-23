package medium.Longest_Uploaded_Prefix;

import org.junit.Test;

/*
Runtime: 516 ms, faster than 5.06% of Java online submissions for Longest Uploaded Prefix.
Memory Usage: 172.8 MB, less than 13.11% of Java online submissions for Longest
Time Complexity : O(n)
Subject : DisjointSet
 */
public class Solution {
  class LUPrefix {
    private int longest_prefix_num = 0;
    private Integer[] parent;
    private boolean[] visited;

    public LUPrefix(int n) {
      visited = new boolean[n + 1];
      parent = new Integer[n + 1];
      parent[0] = 0;
    }

    public void upload(int num) {
      if(!visited[num]) {
        visited[num] = true;
        int root = find(num);
        parent[num] = root;
        parent[num - 1] = root;
      }
      updateLogest();
    }

    public int longest() {
      System.out.println(longest_prefix_num);
      return longest_prefix_num;
    }

    private int find(int cur) {
      if(parent[cur] == null || parent[cur] == cur) {
        return cur;
      }
      int root = find(parent[cur]);
      parent[cur] = root;
      return root;
    }

    private void updateLogest() {
      longest_prefix_num = parent[longest_prefix_num];
    }
  }

  @Test
  public void execute() {
    LUPrefix server = new LUPrefix(4);
    server.upload(3);                    // Upload video 3.
    server.longest();                    // Since video 1 has not been uploaded yet, there is no prefix.
    // So, we return 0.
    server.upload(1);                    // Upload video 1.
    server.longest();                    // The prefix [1] is the longest uploaded prefix, so we return 1.
    server.upload(2);                    // Upload video 2.
    server.longest();                    // The prefix [1,2,3] is the longest
  }
}
