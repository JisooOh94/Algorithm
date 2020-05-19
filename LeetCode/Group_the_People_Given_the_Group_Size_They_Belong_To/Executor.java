package Group_the_People_Given_the_Group_Size_They_Belong_To;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
    @Test
    public void test() {
//        int[] groupSizes = new int[]{3,3,3,3,3,1,3};
        int[] groupSizes = new int[]{2,1,3,3,3,2};
        PerformanceUtil.calcPerformance(new Solution(), (Object)groupSizes);
    }
}
