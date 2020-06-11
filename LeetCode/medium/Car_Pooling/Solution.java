package medium.Car_Pooling;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 3ms(76.36%)
 * Memory : 38.7mb(97.79%)
 */
public class Solution implements Predicate<Boolean, Object> {
    @Test
    public void excute() {
//        int[][] trips = new int[][]{
//                {2,1,5},
//                {3,3,7}
//        };
//        int capacity = 5;
//        int[][] trips = new int[][]{
//                {2, 1, 5},
//                {3, 5, 7}
//        };
//        int capacity = 3;
//        int[][] trips = new int[][]{
//                {3, 2, 7},
//                {3, 7, 9},
//                {8, 3, 9}
//        };
//        int capacity = 11;

        int[][] trips = new int[][]{
                {7, 5, 6}, {6, 7, 8}, {10, 1, 6}
        };
        int capacity = 16;
        PerformanceUtil.calcPerformance(new Solution(), (Object) trips, capacity);
    }

    @Override
    public Boolean test(Object... params) {
        return carPooling((int[][]) params[0], (int) params[1]);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 0) return true;
        else if (trips.length == 1) return trips[0][0] <= capacity;

        int[] pSum = new int[1001];
        for (int[] trip : trips) {
            int sIdx = trip[1];
            int eIdx = trip[2];
            int pCnt = trip[0];

            for (int i = sIdx; i < eIdx; i++) {
                if (pSum[i] + pCnt <= capacity)
                    pSum[i] += pCnt;
                else return false;
            }
        }

        return true;
    }
}
