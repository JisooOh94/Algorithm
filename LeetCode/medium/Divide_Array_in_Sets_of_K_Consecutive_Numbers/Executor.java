package medium.Divide_Array_in_Sets_of_K_Consecutive_Numbers;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,3,4,4,5,6};
        int k = 4;
//        int[] nums = new int[]{3,2,1,2,3,4,3,4,5,9,10,11};
//        int k = 3;
//        int[] nums = new int[]{1,2,3,4};
//        int k = 3;
//        int[] nums = new int[]{3,3,2,2,1,1};
//        int k = 3;
        PerformanceUtil.calcPerformance(new Solution_2(), (Object)nums, k);
    }
}
