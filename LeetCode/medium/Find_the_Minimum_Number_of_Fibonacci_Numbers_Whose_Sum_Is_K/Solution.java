package medium.Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 1ms(89.56%)
 * Memory : 36.6mb(84.80%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        int num = 4;
        PerformanceUtil.calcPerformance(new Solution(), num);
    }
    @Override
    public Integer test(Object... params) {
        return findMinFibonacciNumbers((int)params[0]);
    }

    public int findMinFibonacciNumbers(int num) {
        if(num == 0) return 0;
        else if(num <= 3) return 1;

        int prev_2 = 2;
        int prev_1 = 3;

        while(true) {
            int cur = prev_1 + prev_2;

            if(num == cur) {
                return 1;
            } else if(num < cur) {
                num -= prev_1;
                return findMinFibonacciNumbers(num) + 1;
            }

            prev_2 = prev_1;
            prev_1 = cur;
        }
    }
}
