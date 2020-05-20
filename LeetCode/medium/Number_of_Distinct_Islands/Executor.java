package medium.Number_of_Distinct_Islands;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
    @Test
    public void test() {
//        int[][] grid = new int[][]{
//                {1, 1, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 0, 1, 1},
//                {0, 0, 0, 1, 1}
//        };

//        int[][] grid = new int[][]{
//                {1, 1, 0, 1, 1},
//                {1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1},
//                {1, 1, 0, 1, 1}
//        };

        int[][] grid = new int[][]{
                {1, 1, 0},
                {0, 1, 1},
                {0, 0, 0},
                {1, 1, 1},
                {0, 1, 0},
        };

        PerformanceUtil.calcPerformance(new Solution(), (Object) grid);
    }
}
