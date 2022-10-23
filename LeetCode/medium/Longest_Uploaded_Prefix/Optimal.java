package medium.Longest_Uploaded_Prefix;

import java.util.HashSet;
import java.util.Set;
/*
Runtime: 57 ms, faster than 85.99% of Java online submissions for Longest Uploaded Prefix.
Memory Usage: 123.1 MB, less than 89.53% of Java online submissions for Longest Uploaded Prefix.
Time Complexity : O(n)
amortized Complexity : O(1)
 */
public class Optimal {
  class LUPrefix {
    int last = 0;
    Set<Integer> uploaded;
    public LUPrefix(int n) {
      uploaded = new HashSet<>(n);
    }

    public void upload(int num) {
      uploaded.add(num);
      while(uploaded.contains(last+1)) last++;
    }

    public int longest() {
      return last;
    }
  }
}
