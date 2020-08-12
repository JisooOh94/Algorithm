package medium.Maximum_Length_of_Repeated_Subarray;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] A = new int[]{1,2,3,2,1};
		int[] B = new int[]{3,2,1,4,7,1,1,2,3,2,5,6,7};

		System.out.println(findLength(A, B));
	}
	public int findLength(int[] A, int[] B) {
		int prev = -1;
		int idx = 0;
		int max = 0;
		int[] record = new int[A.length];

		for(int i = 0; i < A.length; i++) {
			int targetNum = A[i];
			boolean foundWithPrev = false, found = false;

			for(int j = 0; j < B.length; j++) {
				if(B[j] == targetNum && 0 < j && B[j - 1] == prev) {
					foundWithPrev = true;
					break;
				} else if(B[j] == targetNum) {
					found = true;
				}
			}

			if(foundWithPrev) {
				record[idx] = record[idx - 1] + 1;
				prev = targetNum;
			} else if(found) {
				record[idx] = 1;
				prev = targetNum;
			} else {
				record[idx] = 0;
				prev = -1;
			}

			max = Math.max(max, record[idx++]);
		}

		return max;
	}
}
