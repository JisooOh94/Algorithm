package medium.Remove_Covered_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 29ms(5.42%)
 * Memory : 38.9mb(97.11%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void test() {
//		int[][] intervals = new int[][]{{3,10},{4,10},{5,11}};
		int[][] intervals = new int[][]{{1,2},{1,4},{3,4}};
		System.out.println(removeCoveredIntervals(intervals));
	}
	public int removeCoveredIntervals(int[][] intervals) {
		List<int[]> rightList = new ArrayList<>();
		List<int[]> leftList = new LinkedList<>();
		for(int[] interval : intervals) {
			leftList.add(interval);
			rightList.add(Arrays.copyOf(interval, 2));
		}

		Collections.sort(leftList, (e1, e2) -> e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : e1[1] < e2[1] ? 1 : e1[1] > e2[1] ? -1 : 0);
		Collections.sort(rightList, (e1, e2) -> e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : 0);

		int rightIdx = 0;
		for(int i = 0; i < leftList.size(); i++) {
			int[] left = leftList.get(i);

			while(rightIdx < rightList.size() && rightList.get(rightIdx)[1] <= left[1]) {
				if(rightList.get(rightIdx)[0] != left[0] || rightList.get(rightIdx)[1] != left[1]) {
					int[] right = rightList.get(rightIdx++);
					for(Iterator<int[]> iter = leftList.iterator(); iter.hasNext();) {
						int[] arr = iter.next();
						if(arr[0] == right[0] && arr[1] == right[1]) {
							iter.remove();
							break;
						}
					}
				} else {
					rightIdx++;
				}
			}

			if(rightIdx == rightList.size()) break;
		}
		return leftList.size();
	}
}
