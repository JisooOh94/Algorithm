package easy.Play_with_Chips;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.9mb(100,00%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        int[] param = new int[]{2,2,2,3,3};
        PerformanceUtil.calcPerformance(new Solution(), (Object)param);
    }
    public Integer test(Object... params) {
        return minCostToMoveChips((int[])params[0]);
    }

    public int minCostToMoveChips(int[] chips) {
        int evenNumCnt = 0;
        int oddNumCnt = 0;

        for(int num : chips) {
            if(num % 2 == 0) evenNumCnt++;
            else oddNumCnt++;
        }

        return Math.min(evenNumCnt, oddNumCnt);
    }
}
