package medium.Largest_Sum_of_Averages;

import org.junit.Test;

/**
 * Runtime : 2ms(100.00%)
 * Memory : 37.7mb(49.91%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] A = new int[]{9,1,2,3,9}; int K = 3;
		int[] A = new int[]{4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698};
		int K = 27;
		System.out.println(largestSumOfAverages(A, K));
	}
	private double recursion(int[] arr, int groupCnt, int idx, double[][] record) {
		if(record[idx][groupCnt - 1] != 0) return record[idx][groupCnt - 1];
		if(groupCnt == 1) {
			double sum = 0;
			for(int i = idx; i < arr.length; i++) {
				sum += arr[i];
			}
			double avg = sum / (arr.length - idx);
			record[idx][groupCnt - 1] = avg;
			return avg;
		}

		double sum = 0;
		int elemCnt = 1;
		double maxAvg = 0.0;
		for(int i = idx; i <= arr.length - groupCnt; i++) {
			sum += arr[i];
			double curAvg = sum / elemCnt++ + recursion(arr, groupCnt - 1, i + 1, record);
			maxAvg = Math.max(maxAvg, curAvg);
		}

		record[idx][groupCnt - 1] = maxAvg;
		return maxAvg;
	}

	public double largestSumOfAverages(int[] A, int K) {
		double[][] record = new double[A.length][K];
		return recursion(A, K, 0, record);
	}
}
