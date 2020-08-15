package medium.Minimum_Score_Triangulation_of_Polygon;

import org.junit.Test;

/**
 * Runtime : 4ms(39.52%)
 * Memory : 39.5mb(5.47%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//		int[] arr = new int[]{1,3,1,4,1,5};
//		int[] arr = new int[]{3,7,4,5};
//		int[] arr = new int[]{4,3,4,3,5};
//		int[] arr= new int[]{2,2,2,2,1};
//		int[] arr = new int[]{5,5,5,4,2,5};
//		int[] arr = new int[]{1,2,3,4,5};
		int[] arr = new int[]{38,76,69,32,24,35,82,30,86,77,92,3,35,20,84,67,23,58,94,10};
		System.out.println(minScoreTriangulation(arr));
	}

	private int recursion(int start, int end, int[] arr, int[][] record) {
		if(Math.abs(start - end) == 1) return 0;
		if(record[start][end] != 0) return record[start][end];
		int min = 999999999;

		for(int i = start + 1; i < end; i++) {
			int cur = arr[start] * arr[i] * arr[end];
			cur += recursion(start, i, arr,record) + recursion(i, end, arr, record);

			min = Math.min(min, cur);
		}

		record[start][end] = min;

		return min;
	}

	public int minScoreTriangulation(int[] arr) {
		int[][] record = new int[arr.length][arr.length];
		return recursion(0, arr.length - 1, arr, record);
	}
}
