package medium.Minimum_Number_of_Arrows_to_Burst_Balloons;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;

/**
 * Runtime : 35ms(10.82%)
 * Memory : 57.3mb(5.79%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        int[][] param = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        //int[][] param = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
//        int[][] param = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        PerformanceUtil.calcPerformance(new Solution(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return findMinArrowShots((int[][])params[0]);
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        else if(points.length == 1) return 1;

        Arrays.sort(points, (e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : 0);

        int arrowCnt = 1;
        int startIdx = 0;
        int curIdx = startIdx + 1;
        int endMin = points[startIdx][1];

        while(curIdx < points.length) {
            if(points[startIdx][1] < points[curIdx][0] || endMin < points[curIdx][0]) {
                arrowCnt++;
                startIdx = curIdx;
                endMin = points[startIdx][1];
            } else if (points[curIdx][1] < endMin) {
                 endMin = points[curIdx][1];
            }

            curIdx++;
        }

        return arrowCnt;
    }
}
