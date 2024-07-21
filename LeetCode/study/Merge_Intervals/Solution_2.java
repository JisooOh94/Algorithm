package study.Merge_Intervals;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * 2ms(98.13%)
 * 46.65MB(21.07%)
 */
public class Solution_2 {
  @Test
  public void test() {
    int[][] intervals = {{2,3},{5,5},{2,2},{3,4},{3,4}};
    int[][] result = merge(intervals);
    int a = 0;
  }
  public int[][] merge(int[][] intervals) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int[] interval : intervals) {
      min = Math.min(interval[0], min);
      max = Math.max(interval[0], max);
    }

    Integer[] rangeRecord = new Integer[max - min + 1];

    for (int[] interval : intervals) {
      if (rangeRecord[interval[0] - min] != null) {
        rangeRecord[interval[0] - min] = Math.max(rangeRecord[interval[0] - min], interval[1] - min);
      } else {
        rangeRecord[interval[0] - min] = interval[1] - min;
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
          result.add(new int[]{start + min, end + min});
          start = i;
          end = rangeRecord[start];
        } else if (i <= end) {
          end = Math.max(end, rangeRecord[i]);
        }
      }
    }

    result.add(new int[]{start + min, end + min});

    int[][] resultArr = new int[result.size()][2];
    result.toArray(resultArr);
    return resultArr;
  }
}
