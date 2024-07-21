package study.Reverse_Integer;

/**
 * 1ms(75.45%)
 * 40.73MB(42.49%)
 */
public class Solution_2 {

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

    int reversedNum = 0;
    for (int i = numStr.length() - 1; 0 <= i; i--) {
      reversedNum = reversedNum * 10 + (numStr.charAt(i) - '0');
    }

    return x < 0 ? reversedNum * -1 : reversedNum;
  }
}
