package medium.Maximum_Odd_Binary_Number;

import org.junit.Test;

/**
 * Runtime : 2ms (78.98%);
 * Memory : 42.93mb (84.53%)
 */
public class Solution_2 {
  @Test
  public void execute() {
    String str = "010";
    String result = maximumOddBinaryNumber(str);
    System.out.println(result);
  }

  public String maximumOddBinaryNumber(String s) {
    StringBuilder oneBuilder = new StringBuilder();
    StringBuilder zeroBuilder = new StringBuilder();

    boolean skipForTrailingOne = true;
    for (char num : s.toCharArray()) {
      if (num == '0') zeroBuilder.append(num);
      else if (skipForTrailingOne) {
        skipForTrailingOne = false;
        continue;
      }
      else oneBuilder.append(num);
    }

    return oneBuilder.append(zeroBuilder).append('1').toString();
  }
}
