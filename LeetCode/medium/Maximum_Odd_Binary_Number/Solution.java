package medium.Maximum_Odd_Binary_Number;

import org.junit.Test;

/**
 * Runtime : 3ms (36.02%);
 * Memory : 43.72mb (27.23%)
 */
public class Solution {
  @Test
  public void execute() {
    String str = "1";
    String result = maximumOddBinaryNumber(str);
    System.out.println(result);
  }

  public String maximumOddBinaryNumber(String s) {
    StringBuilder oneBuilder = new StringBuilder();
    StringBuilder zeroBuilder = new StringBuilder();

    for (char num : s.toCharArray()) {
      if (num == '0') zeroBuilder.append(num);
      else oneBuilder.append(num);
    }

    return oneBuilder.deleteCharAt(oneBuilder.length() - 1).append(zeroBuilder).append('1').toString();
  }
}
