package medium.Remove_Covered_Intervals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 5ms(47.79%)
 * Memory : 39.5mb(20.00%)
 * Time Complexity : O(sort)
 * Subject : greedy
 */
public class Solution_2 {
	@Test
	public void test() {
//		int[][] intervals = new int[][]{{3,10},{4,10},{5,11}};
//		int[][] intervals = new int[][]{{1,2},{1,4},{3,4}};
		int[][] intervals = new int[][]{{1,4},{3,6},{2,8}};
		System.out.println(removeCoveredIntervals(intervals));
	}

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (e1, e2) -> e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : e1[1] < e2[1] ? 1 : e1[1] > e2[1] ? -1 : 0);

		int ucLeft = -1;
		int ucRight = -1;
		int cnt = 0;
		for(int[] intv : intervals) {
			if(ucLeft < intv[0] && ucRight < intv[1]) {
				ucLeft = intv[0];
				ucRight = intv[1];
				cnt++;
			}
		}

		return cnt;
	}
}
