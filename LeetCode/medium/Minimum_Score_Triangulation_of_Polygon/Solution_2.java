package medium.Minimum_Score_Triangulation_of_Polygon;

import org.junit.Test;

public class Solution_2 {
	@Test
	public void execute() {
//		int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//		int[] arr = new int[]{1,3,1,4,1,5};
//		int[] arr = new int[]{3,7,4,5};
//		int[] arr = new int[]{4,3,4,3,5};
//		int[] arr= new int[]{2,2,2,2,1};
//		int[] arr = new int[]{5,5,5,4,2,5};
		int[] arr = new int[]{1,2,3,4,5};
		System.out.println(minScoreTriangulation(arr));
	}

	private int recursion(int start, int end, int[] arr) {
		if(Math.abs(start - end) == 1) return 0;

		int range = start < end ? end - start : end + arr.length - start;
		int min = 99999;

		for(int p1 = 0; p1 < range; p1++) {
			int p2 = p1 + 1;
			for(int p3 = p2 + 1; p3 < p1 + arr.length; p3++) {
				int cur = arr[start + p1] * arr[(start + p2) % arr.length] * arr[(start + p3) % arr.length];
				cur += recursion(start + p2, start + p3, arr) + recursion(start + p3, start + p1, arr);
				min = Math.min(min, cur);
			}
		}

		return min;
	}

	public int minScoreTriangulation(int[] arr) {
		return recursion(0, arr.length, arr);
	}
}
