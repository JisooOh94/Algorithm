package medium.Optimal_Partition_of_String;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * Runtime : 27ms
 * Memory : 44.87%
 * Subject : greedy
 */
public class Solution_2 {
  @Test
  public void execute() {
    String str = "abacaba";
    int result = partitionString(str);
    System.out.println(result);
  }

  public int partitionString(String s) {
    int subStringCnt = 0;
    Set<Character> exist = new HashSet<>();
    for (char ch : s.toCharArray()) {
      if (exist.add(ch) == false) {
        subStringCnt++;
        exist.clear();
        exist.add(ch);
      }
    }
    return subStringCnt + 1;
  }

}
