package medium.Optimal_Partition_of_String;

import org.junit.Test;

/**
 * Runtime : 6ms (95.59%)
 * Memory : 45.09 (70.37%)
 * Subject : greedy
 */
public class Solution_1 {
  private static final int START_ASCII_CODE = 'a';

  @Test
  public void execute() {
    String str = "abacaba";
    int result = partitionString(str);
    System.out.println(result);
  }

  public int partitionString(String s) {
    int subStringCnt = 0;
    boolean[] exist = new boolean['z' - 'a' + 1];
    for (char ch : s.toCharArray()) {
      if (exist[ch - START_ASCII_CODE]) {
        subStringCnt++;
        exist = new boolean['z' - 'a' + 1];
      }
      exist[ch - START_ASCII_CODE] = true;
    }
    return subStringCnt + 1;
  }
}
