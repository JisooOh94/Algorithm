package study.Reverse_Integer;

/**
 * 1ms(75.45%)
 * 41.37MB(5.25%)
 */
public class Solution_1 {

  private static final String MIN = String.valueOf(Integer.MIN_VALUE).substring(1);
  private static final String MAX = String.valueOf(Integer.MAX_VALUE);

  public int reverse(int x) {
    String numStr = x < 0 ? String.valueOf(x).substring(1) : String.valueOf(x);

    String maxNum = x < 0 ? MIN : MAX;
    if (numStr.length() == maxNum.length()) {
      for (int i = 0; i < numStr.length(); i++) {
        if (numStr.charAt(numStr.length() - i - 1) < maxNum.charAt(i)) {
          break;
        } else if (numStr.charAt(numStr.length() - i - 1) > maxNum.charAt(i)) {
          return 0;
        } else {
          continue;
        }
      }
    }

    StringBuilder reversedStrBuilder = new StringBuilder();
    for (int i = numStr.length() - 1; 0 <= i; i--) {
      reversedStrBuilder.append(numStr.charAt(i));
    }

    String reversedStr = reversedStrBuilder.toString();

    return x < 0 ? Integer.parseInt(reversedStr) * -1 : Integer.parseInt(reversedStr);
  }
}
