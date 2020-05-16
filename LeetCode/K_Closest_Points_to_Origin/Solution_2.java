package K_Closest_Points_to_Origin;

import java.util.Arrays;

import org.junit.Test;
import util.Predicate;

/**
 * Runtime : 24ms(60.04%)
 * Memory : 47.8mb(100.0%)
 */
public class Solution_2 implements Predicate<int[][], Object> {
	@Test
	public int[][] test(Object... params) {
		int[][] result = kClosest((int[][])params[0], (int)params[1]);
		for(int[] arr : result) {
			System.out.println(arr[0] + ", " + arr[1]);
		}
		return result;
	}

	public int[][] kClosest(int[][] points, int k) {
		if(points.length == 1) return points;

		Arrays.sort(points, (a, b) -> a[0]*a[0] + a[1]*a[1]  > b[0]*b[0] + b[1]*b[1] ? 1 : a[0]*a[0] + a[1]*a[1]  < b[0]*b[0] + b[1]*b[1] ? -1 : 0);

		return Arrays.copyOf(points, k);
	}
}
