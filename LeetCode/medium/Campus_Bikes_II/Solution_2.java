package medium.Campus_Bikes_II;

import org.junit.Test;

/**
 * Runtime : 368ms(39.97%)
 * Memory : 37mb(61.02%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[][] workers = new int[][]{{0,0},{1,1},{2,0}};
		int[][] bikes = new int[][]{{1,0},{2,2},{2,1}};
		System.out.println(assignBikes(workers, bikes));
	}
	public int assignBikes(int[][] workers, int[][] bikes) {
		dfs(workers, 0, bikes, new boolean[bikes.length], 0);
		return min;
	}

	int min = Integer.MAX_VALUE;
	void dfs(int[][] workers, int i, int[][] bikes, boolean[] used, int sum) {
		if (i == workers.length) {
			min = Math.min(min, sum);
			return;
		}

		if (sum > min) return;  // early termination

		for (int j = 0; j < bikes.length; ++j) {
			if (used[j]) continue;
			used[j] = true;
			dfs(workers, i+1, bikes, used, sum + getDistance(workers[i], bikes[j]));
			used[j] = false;
		}
	}

	int getDistance(int[] worker, int[] bike) {
		return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	}
}
