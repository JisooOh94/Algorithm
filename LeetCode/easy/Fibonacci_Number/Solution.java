package easy.Fibonacci_Number;

public class Solution {

  private int calc(int num, int[] record) {
    if (num == 1) return 1;
    if (num == 0) return 0;
    if (record[num] != 0) return record[num];

    int result = calc(num - 1, record) + calc(num - 2, record);
    record[num] = result;
    return result;
  }

  public int fib(int n) {
    int[] record = new int[n + 1];
    return calc(n, record);
  }
}
