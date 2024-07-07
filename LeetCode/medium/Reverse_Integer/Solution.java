package medium.Reverse_Integer;

import org.junit.Test;

/**
 * 2 ms(10.40%)
 * 41.00MB(22.99%)
 */
public class Solution {

  private static final String MIN = String.valueOf(Integer.MIN_VALUE).substring(1);
  private static final String MAX = String.valueOf(Integer.MAX_VALUE);

  public int reverse(int x) {
    String numStr = x < 0 ? String.valueOf(x).substring(1) : String.valueOf(x);

    StringBuilder reversedStrBuilder = new StringBuilder();
    for (int i = numStr.length() - 1; 0 <= i; i--) {
      reversedStrBuilder.append(numStr.charAt(i));
    }

    String reversedStr = reversedStrBuilder.toString();

    String maxNum = x < 0 ? MIN : MAX;
    if (reversedStr.length() == maxNum.length()) {
      for (int i = 0; i < reversedStr.length(); i++) {
        if (reversedStr.charAt(i) < maxNum.charAt(i)) {
          break;
        } else if (reversedStr.charAt(i) > maxNum.charAt(i)) {
          return 0;
        } else {
          continue;
        }
      }
    }

    return x < 0 ? Integer.parseInt(reversedStr) * -1 : Integer.parseInt(reversedStr);
  }
}
