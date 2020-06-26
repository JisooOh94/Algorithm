package medium.Non_overlapping_Intervals;

import org.junit.Test;

import java.util.*;

/**
 * Runtime : 3ms(66.93%)
 * Memory : 39.6mb(44.19%)
 */
public class Solution {
    private static final int START_P = 0;
    private static final int END_P = 1;

    @Test
    public void test() {
        int[][] param = new int[][]{{1,2},{2,3},{3,4},{1,3}};
//        int[][] param = new int[][]{{1,2},{1,2},{1,2}};
        //int[][] param = new int[][]{{1,2},{2,3}};

        System.out.print(eraseOverlapIntervals(param));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
//        Arrays.sort(intervals, Comparator.comparingInt(e -> e[END_P]));
        Arrays.sort(intervals, (e1, e2) -> e1[END_P] > e2[END_P] ? 1 : e1[END_P] < e2[END_P] ? -1 : e1[START_P] > e2[START_P] ? 1 : e1[START_P] < e2[START_P] ? -1 : 0);
        int[] frontLine = intervals[0];

        int removeCnt = 0;
        for(int i = 1; i < intervals.length; i++) {
            int[] curLIne = intervals[i];
            if(frontLine[END_P] > curLIne[START_P]) removeCnt++;
            else frontLine = curLIne;
        }

        return removeCnt;
    }


}
