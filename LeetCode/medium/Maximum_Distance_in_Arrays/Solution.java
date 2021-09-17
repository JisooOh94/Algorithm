package medium.Maximum_Distance_in_Arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 21ms(17.98%)
 * Memory : 69.7mb(22.47%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		List<List<Integer>> list = Arrays.asList(Arrays.asList(1),Arrays.asList(1));
		List<List<Integer>> list = Arrays.asList(
				Arrays.asList(-1,1),
				Arrays.asList(-3,1,4),
				Arrays.asList(-2,-1,0,2));

		System.out.println(maxDistance(list));
	}

	private static final int MIN = 0;
	private static final int MAX = 1;
	public int maxDistance(List<List<Integer>> arrays) {
		Integer firstMinIdx = null, firstMaxIdx = null, secondMinIdx = null, secondMaxIdx = null;

		int[][] minMaxVals = new int[arrays.size()][2];

		for(int i = 0; i < arrays.size(); i++) {
			minMaxVals[i][MIN] = 100000;
			minMaxVals[i][MAX] = -100000;
			for(int val : arrays.get(i)) {
				if(val < minMaxVals[i][MIN]) minMaxVals[i][MIN] = val;
					if(minMaxVals[i][MAX] < val) minMaxVals[i][MAX] = val;
			}
			if(firstMinIdx == null && firstMaxIdx == null) {
				firstMinIdx = i;
				firstMaxIdx = i;
			} else {
				if(minMaxVals[i][MIN] <= minMaxVals[firstMinIdx][MIN]) {
					secondMinIdx = firstMinIdx;
					firstMinIdx = i;
				} else if(secondMinIdx == null || minMaxVals[i][MIN] < minMaxVals[secondMinIdx][MIN]) {
					secondMinIdx = i;
				}

				if(minMaxVals[firstMaxIdx][MAX] <= minMaxVals[i][MAX]) {
					secondMaxIdx = firstMaxIdx;
					firstMaxIdx = i;
				} else if(secondMaxIdx == null || minMaxVals[secondMaxIdx][MAX] < minMaxVals[i][MAX]) {
					secondMaxIdx = i;
				}
			}
		}

		return firstMaxIdx == firstMinIdx ? Math.max(Math.abs(minMaxVals[firstMaxIdx][MAX] - minMaxVals[secondMinIdx][MIN]), Math.abs(minMaxVals[secondMaxIdx][MAX] - minMaxVals[firstMinIdx][MIN])) : Math.abs(minMaxVals[firstMaxIdx][MAX] - minMaxVals[firstMinIdx][MIN]);
	}
}
