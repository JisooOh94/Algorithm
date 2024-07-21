package study.Merge_Intervals;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * 5ms(97.70%)
 * 49.60MB(5.65%)
 */
public class Solution {
  @Test
  public void test() {
    int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
    int[][] result = merge(intervals);
    int a = 0;
  }
  public int[][] merge(int[][] intervals) {
    Integer[] rangeRecord = new Integer[10001];

    for (int[] interval : intervals) {
      if (rangeRecord[interval[0]] != null) {
        rangeRecord[interval[0]] = Math.max(rangeRecord[interval[0]], interval[1]);
      } else {
        rangeRecord[interval[0]] = interval[1];
      }
    }

    List<int[]> result = new LinkedList<>();

    int start = - 1, end = -1;
    for (int i = 0; i < rangeRecord.length; i++) {
      if (rangeRecord[i] != null) {
        if (start == -1) {
          start = i;
          end = rangeRecord[start];
        } else if (end < i) {
          result.add(new int[]{start, end});
          start = i;
          end = rangeRecord[start];
        } else if (i <= end) {
          end = Math.max(end, rangeRecord[i]);
        }
      }
    }

    result.add(new int[]{start, end});

    int[][] resultArr = new int[result.size()][2];
    result.toArray(resultArr);
    return resultArr;
  }
}
