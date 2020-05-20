package medium.Combination_Sum;

import org.junit.Test;
import util.PerformanceUtil;

/**
 * Runtime :
 */
public class Executor {
    @Test
    public void test() {
        int[] candidates = new int[]{2,3,6,7};
        int targetNum = 7;
        PerformanceUtil.calcPerformance(new Solution(), candidates, targetNum);
    }
}
