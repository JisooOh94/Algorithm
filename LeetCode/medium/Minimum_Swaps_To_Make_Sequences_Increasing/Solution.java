package medium.Minimum_Swaps_To_Make_Sequences_Increasing;

import org.junit.Test;

/**
 * Runtime : 2ms(71.93%)
 * Memory : 39.6mb(71.34%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] A = new int[]{1,3,5,4};
		int[] B = new int[]{1,2,3,7};
		System.out.println(minSwap(A, B));
	}
	private static final int SWAP = 0;
	private static final int NO_SWAP = 1;

	private int recursion(int curIdx, int isSwapped, int[] A, int[] B, Integer[][] record) {
		if(curIdx == A.length) return 0;
		else if(record[curIdx][isSwapped] != null) return record[curIdx][isSwapped];

		int aPrevNum = isSwapped == SWAP ? B[curIdx - 1] : A[curIdx - 1];
		int bPrevNum = isSwapped == SWAP ? A[curIdx - 1] : B[curIdx - 1];

		int minCnt = 99999;
		if(aPrevNum < A[curIdx] && bPrevNum < B[aPrevNum]) {
			int noSwapResult = recursion(curIdx + 1, NO_SWAP, A, B, record);
			if(noSwapResult != -1) minCnt = Math.min(minCnt, noSwapResult);
		}
		if(aPrevNum < B[curIdx] && bPrevNum < A[curIdx]) {
			int swapResult = recursion(curIdx + 1, SWAP, A, B, record);
			if(swapResult != -1) minCnt = Math.min(minCnt, swapResult + 1);
		}

		minCnt = minCnt == 99999 ? -1 : minCnt;
		record[curIdx][isSwapped] = minCnt;
		return minCnt;
	}

	public int minSwap(int[] A, int[] B) {
		Integer[][] record = new Integer[A.length][2];
		return Math.min(recursion(1, NO_SWAP, A, B, record), recursion(1, SWAP, A, B, record) + 1);
	}
}
