package medium.K_Closest_Points_to_Origin;

import java.util.PriorityQueue;

import org.junit.Test;
import util.Predicate;

/**
 * Runtime : 41ms(19.84%)
 * Memory : 114.8mb(5.59%)
 */
public class Solution implements Predicate<int[][], Object> {
	@Test
	public int[][] test(Object... params) {
		int[][] result = kClosest((int[][])params[0], (int)params[1]);
		for(int[] arr : result) {
			System.out.println(arr[0] + ", " + arr[1]);
		}
		return result;
	}

	public class DistInfo {
		int[] pos;
		int dist;

		public DistInfo(int y, int x) {
			pos = new int[]{y,x};
			dist = y * y + x * x;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		if(points.length == 1) return points;

		PriorityQueue<DistInfo> queue = new PriorityQueue<>((a, b) -> a.dist > b.dist ? 1 : a.dist < b.dist ? -1 : 0);

		for(int[] point : points) {
			queue.add(new DistInfo(point[0], point[1]));
		}

		int[][] result = new int[k][2];

		for(int i = 0; i < k; i++) {
			result[i] = queue.poll().pos;
		}

		return result;
	}
}
