package medium.Maximum_Odd_Binary_Number;

import java.util.LinkedList;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Runtime : 6ms
 * Memory : 44.48mb
 */
public class Solution_3 {
  @Test
  public void execute() {
    String str = "010";
    String result = maximumOddBinaryNumber(str);
    System.out.println(result);
  }

  public String maximumOddBinaryNumber(String s) {
    LinkedList<Character> list = new LinkedList<>();

    boolean skipForTrailingOne = true;
    for (char num : s.toCharArray()) {
      if (num == '0') list.offerLast(num);
      else if (skipForTrailingOne) {
        skipForTrailingOne = false;
        continue;
      }
      else list.offerFirst(num);
    }
    list.offerLast('1');

    StringBuilder builder = new StringBuilder();
    list.stream().forEach(builder::append);
    return builder.toString();
  }
}
