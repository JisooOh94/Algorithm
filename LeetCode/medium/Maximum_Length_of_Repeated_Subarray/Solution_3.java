package medium.Maximum_Length_of_Repeated_Subarray;

import org.junit.Test;

/**
 * Runtime : 118 ms(19.79%%)
 * Memory : 48.6 mb(61.28%)
 */
public class Solution_3 {
	@Test
	public void execute() {
		int[] A = new int[]{1,2,3,2,1}; int[] B = new int[]{3,2,1,4,7,1};
//		int[] A = new int[]{1,2,3,2,1, 2,2,3,2,1,4,6,6}; int[] B = new int[]{3,2,1,4,7,1};
//		int[] A = new int[]{0, 1, 1, 1, 1}; int[] B = new int[]{1, 0, 1, 0, 1};
		System.out.println(findLength(A, B));
	}

	private int recursion(int aIdx, int[] A, int bIdx, int[] B, int[][] record) {
		if (aIdx == A.length || bIdx == B.length) return 0;
		else if(record[aIdx][bIdx] != 0) return record[aIdx][bIdx];

		if (A[aIdx] == B[bIdx]) {
			record[aIdx][bIdx] = 1 + recursion(aIdx + 1, A, bIdx + 1, B, record);
		}

		return record[aIdx][bIdx];
	}

	public int findLength(int[] A, int[] B) {
		int max = 0;
		int[][] record = new int[A.length][B.length];

		for (int i = A.length - 1; 0 <= i; i--) {
			for(int j = 0; j < B.length; j++) {
				max =  Math.max(max, recursion(i, A, j, B, record));
			}
		}
		return max;
	}
}
