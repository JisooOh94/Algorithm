package medium.Triangle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.8mb(57.95%)
 */
public class Solution {
	@Test
	public void execute() {
		List<List<Integer>> triangle = new LinkedList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		System.out.println(minimumTotal(triangle));
	}
	private int recursion(int idx, int layer, List<List<Integer>> list, Integer[][] memo) {
		if(layer == list.size() - 1) return list.get(layer).get(idx);
		else if(memo[layer][idx] != null) return memo[layer][idx];

		int min = list.get(layer).get(idx) + Math.min(recursion(idx, layer + 1, list, memo), recursion(idx + 1, layer + 1, list, memo));
		memo[layer][idx] = min;
		return min;
	}
	public int minimumTotal(List<List<Integer>> triangle) {
		Integer[][] memo = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
		return recursion(0, 0, triangle, memo);
	}
}
