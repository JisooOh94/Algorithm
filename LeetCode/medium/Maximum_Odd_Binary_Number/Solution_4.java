package medium.Maximum_Odd_Binary_Number;

import org.junit.Test;

/**
 * Runtime : 1ms (100.00%);
 * Memory : 43.22mb (51.57%)
 */
public class Solution_4 {
  @Test
  public void execute() {
    String str = "010";
    String result = maximumOddBinaryNumber(str);
    System.out.println(result);
  }

  public String maximumOddBinaryNumber(String s) {
    int oneCnt = 0;
    for (char num : s.toCharArray()) {
      if (num == '1') {
        oneCnt++;
      }
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < oneCnt - 1; i++) {
      builder.append('1');
    }

    for (int i = 0; i < s.length() - oneCnt; i++) {
      builder.append('0');
    }

    return builder.append('1').toString();
  }
}
