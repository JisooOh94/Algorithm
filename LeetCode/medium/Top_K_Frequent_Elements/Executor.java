package medium.Top_K_Frequent_Elements;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
    @Test
    public void test(){
//        int[] nums = new int[]{1,1,1,2,2,3};
//        int k = 2;
        int[] nums = new int[]{1,1,1,2,2,3,4,4,4,4,4,4,4,6,6,6,6,6,8,8,8,8,8,8,8,8,8,8,8,8};
        int k = 3;
//        int[] nums = new int[]{1,2};
//        int k = 2;
        PerformanceUtil.calcPerformance(new Solution_3(), (Object)nums, k);
    }
}
