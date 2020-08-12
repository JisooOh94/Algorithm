package medium.Maximum_Length_of_Repeated_Subarray;

import org.junit.Test;

/**
 * Runtime : 215ms(8.34%)
 * Memory : 49.1mb(37.17%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] A = new int[]{1,2,3,2,1}; int[] B = new int[]{3,2,1,4,7,1};
//		int[] A = new int[]{1,2,3,2,1, 2,2,3,2,1,4,6,6}; int[] B = new int[]{3,2,1,4,7,1};
//		int[] A = new int[]{0, 1, 1, 1, 1}; int[] B = new int[]{1, 0, 1, 0, 1};
		System.out.println(findLength(A, B));
	}

	private int recursion(int aIdx, int[] A, int bIdx, int[] B, int[][] record) {
		if (aIdx == A.length || bIdx == B.length) return 0;
		else if(record[aIdx][bIdx] != -1) return record[aIdx][bIdx];

		if (A[aIdx] == B[bIdx]) {
			record[aIdx][bIdx] = 1 + recursion(aIdx + 1, A, bIdx + 1, B, record);
		} else {
			record[aIdx][bIdx] = 0;
		}

		return record[aIdx][bIdx];
	}

	public int findLength(int[] A, int[] B) {
		int max = 0;
		int[][] record = new int[A.length][B.length];

		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B.length; j++)
				record[i][j] = -1;
		}

		for (int i = 0; i < A.length; i++) {
			for(int j = 0; j < B.length; j++) {
				if(record[i][j] != -1) max =  Math.max(max, record[i][j]);
				else if(A[i] == B[j]) {
					record[i][j] = 1 + recursion(i + 1, A, j + 1, B, record);
					max =  Math.max(max, record[i][j]);
				} else {
					record[i][j] = 0;
				}
			}
		}
		return max;
	}
}
