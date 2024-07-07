package medium.Basic_Calculator_II;

import java.util.Stack;
import org.junit.Test;

/**
 * 26ms(32.52%)
 * 46.00MB(58.87%)
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class Solution {
  @Test
  public void test() {
    String str = "2*3+4";
    System.out.println(calculate(str));
  }

  public int calculate(String s) {
    s = s.replaceAll(" ", "");
    Stack<Integer> stack = new Stack<>();

    char operation = '+';
    int currentNum = 0;

    for (int i = 0; i < s.length() + 1; i++) {
      char ch = i == s.length() ? ' ' : s.charAt(i);

      if (isNumber(ch)) {
        currentNum = accumNum(currentNum, ch);
      } else {
        if (operation == '+' || operation == '-') {
          stack.push(operation == '+' ? currentNum : currentNum * -1);
          currentNum = 0;
        } else {
          int lastNum = stack.pop();
          currentNum = processOperation(operation, lastNum, currentNum);
          stack.push(currentNum);
          currentNum = 0;
        }
        operation = ch;
      }
    }

    int result = 0;
    while(stack.isEmpty() == false) {
      result += stack.pop();
    }

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
