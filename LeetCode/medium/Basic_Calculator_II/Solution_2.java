package medium.Basic_Calculator_II;

import org.junit.Test;

/**
 * 11ms(94.35%)
 * 44.55MB(91.51%)
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class Solution_2 {
  @Test
  public void test() {
//    String str = "2*3+4";
    String str = "3+2*2";
    System.out.println(calculate(str));
  }

  public int calculate(String s) {
    s = s.replaceAll(" ", "");

    int lastNum = 0;
    int currentNum = 0;
    int result = 0;
    char lastOperation = '+';

    for (char ch : s.toCharArray()) {
      if (isNumber(ch)) {
        currentNum = accumNum(currentNum, ch);
      } else {
        if (lastOperation == '+' || lastOperation == '-') {
          result += lastNum;
          lastNum = lastOperation == '+' ? currentNum : currentNum * -1;
          currentNum = 0;
        } else {
          lastNum = processOperation(lastOperation, lastNum, currentNum);
          currentNum = 0;
        }
        lastOperation = ch;
      }
    }
    lastNum = processOperation(lastOperation, lastNum, currentNum);
    result += lastNum;
    return result;
  }

  private int processOperation(char operation, int num_1, int num_2) {
    switch (operation) {
      case '+':
        return num_1 + num_2;
      case '-':
        return num_1 - num_2;
      case '*':
        return num_1 * num_2;
      case '/':
        return num_1 / num_2;
    }
    return 0;
  }

  private int accumNum(int num, char currentNum) {
    return num * 10 + currentNum - '0';
  }

  private boolean isNumber(char ch) {
    return '0' <= ch && ch <= '9';
  }
}
