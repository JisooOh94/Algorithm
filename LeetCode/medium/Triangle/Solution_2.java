package medium.Triangle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 2ms(84.19%)
 * Memory : 39.7mb(64.08%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		List<List<Integer>> triangle = new LinkedList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		System.out.println(minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		Integer[][] memo = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
		memo[0][0] = triangle.get(0).get(0);
		for(int i = 1; i < triangle.size(); i++) {
			List<Integer> list = triangle.get(i);
			memo[i][0] = list.get(0) + memo[i - 1][0];
			memo[i][list.size() - 1] = list.get(list.size() - 1) + memo[i - 1][list.size() - 2];

			for(int j = 1; j < list.size() - 1; j++) {
				memo[i][j] = list.get(j) + Math.min(memo[i - 1][j - 1], memo[i - 1][j]);
			}
		}

		int min = 99999;
		for(int i = 0; i < memo[memo.length - 1].length; i++) {
			min = Math.min(min, memo[memo.length - 1][i]);
		}
		return min;
	}
}
