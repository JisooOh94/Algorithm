package medium.Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 9ms(98.44%)
 * Memory : 39.7mb(66.39%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] pairs = new int[][]{{1,2},{2,3},{3,4}};
		int[][] pairs = new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
		System.out.println(findLongestChain(pairs));
	}
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (e1, e2) -> e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : 0);

		int length = 1;
		int prev = pairs[0][1];
		for(int i = 1; i < pairs.length; i++) {
			if(pairs[i][0] > prev) {
				prev = pairs[i][1];
				length++;
			}
		}

		return length;
	}
}
