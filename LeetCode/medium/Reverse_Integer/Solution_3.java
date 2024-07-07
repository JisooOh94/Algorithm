package medium.Reverse_Integer;

/**
 * 1ms(75.45%)
 * 40.73MB(42.49%)
 */
public class Solution_3 {

  private static final String MIN = String.valueOf(Integer.MIN_VALUE).substring(1);
  private static final String MAX = String.valueOf(Integer.MAX_VALUE);

  public int reverse(int x) {
    String numStr = x < 0 ? String.valueOf(x).substring(1) : String.valueOf(x);

    String maxNum = x < 0 ? MIN : MAX;
    int reversedNum = 0;

    if (numStr.length() == maxNum.length()) {
      Boolean isOverflow = null;
      for (int i = 0; i < numStr.length(); i++) {
        if (isOverflow == null) {
          if (numStr.charAt(numStr.length() - i - 1) < maxNum.charAt(i)) {
            isOverflow = false;
          } else if (numStr.charAt(numStr.length() - i - 1) > maxNum.charAt(i)) {
            return 0;
          }
        }
        reversedNum = reversedNum * 10 + (numStr.charAt(numStr.length() - i - 1) - '0');
      }
    } else {
      for (int i = 0; i < numStr.length(); i++) {
        reversedNum = reversedNum * 10 + (numStr.charAt(numStr.length() - i - 1) - '0');
      }
    }

    return x < 0 ? reversedNum * -1 : reversedNum;
  }
}
