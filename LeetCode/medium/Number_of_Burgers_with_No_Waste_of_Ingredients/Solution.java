package medium.Number_of_Burgers_with_No_Waste_of_Ingredients;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.*;

/**
 * Runtime : 1ms(100.00%)
 * Memory : 39.6mb(23.33%)
 */
public class Solution implements Predicate<List, Object> {
    @Test
    public void execute() {
        int x = 2385088;
        int y = 164763;
        PerformanceUtil.calcPerformance(new Solution(), x, y);
    }
    @Override
    public List<Integer> test(Object... params) {
        return numOfBurgers((int)params[0], (int)params[1]);
    }

    public List<Integer> numOfBurgers(int x, int y) {
        int num = x - 2 * y;
        int A = num / 2;
        if(num < 0 || num % 2 != 0 || A > y) return Collections.emptyList();

        int B = y - A;

        return Arrays.asList(A, B);
    }
}
