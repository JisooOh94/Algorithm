package medium.Knight_Probability_in_Chessboard;

import org.junit.Test;

/**
 * Runtime : 3ms(97.21%)
 * Memory : 37.7mb(54.43%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] params = new int[]{3, 2, 0, 0};
		int[] params = new int[]{8, 30, 6, 4};
		System.out.println(knightProbability(params[0], params[1], params[2], params[3]));
	}
	private int[][] mod = new int[][]{
			{-2, -1},
			{-2, 1},
			{-1 , -2},
			{1, -2},
			{2, -1},
			{2, 1},
			{-1, 2},
			{1, 2},
	};
	private double recursion(int range, int x, int y, int remainMove, double[][][] record) {
		if(x < 0 || range <= x || y < 0 || range <= y) return 0;
		else if(remainMove == 0) return 1;
		else if(record[y][x][remainMove] != 0.0) return record[y][x][remainMove];

		double probability = 0.0;
		for(int i = 0; i < mod.length; i++) {
			probability += recursion(range, x + mod[i][0], y + mod[i][1], remainMove - 1, record) / 8;
		}

		record[y][x][remainMove] = probability;
		return probability;
	}

	public double knightProbability(int N, int K, int r, int c) {
		double[][][] record = new double[N][N][K + 1];
		return recursion(N, c, r, K, record);
	}
}
