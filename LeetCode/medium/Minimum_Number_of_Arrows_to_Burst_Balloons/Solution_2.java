package medium.Minimum_Number_of_Arrows_to_Burst_Balloons;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;

/**
 * Runtime : 26ms(23.02%)
 * Memory : 57.3mb(5.79%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        //int[][] param = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        //int[][] param = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int[][] param = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        PerformanceUtil.calcPerformance(new Solution_2(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return findMinArrowShots((int[][])params[0]);
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        else if(points.length == 1) return 1;

        Arrays.sort(points, (e1, e2) -> e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : 0);

        int arrowCnt = 1;
        int startIdx = 0;
        int curIdx = startIdx + 1;

        while(curIdx < points.length) {
            if(points[startIdx][1] < points[curIdx][0]) {
                arrowCnt++;
                startIdx = curIdx;
            }

            curIdx++;
        }

        return arrowCnt;
    }
}
