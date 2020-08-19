package medium.Length_of_Longest_Fibonacci_Subsequence;

import org.junit.Test;

/**
 * Runtime : 192ms(11.36%)
 * Memory : 50.2mb(44.09%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		int[] arr = new int[]{1,3,7,11,12,14,18};
		System.out.println(lenLongestFibSubseq(arr));
	}
	private int recursion(int idx_1, int idx_2, int[] arr, Integer[][] record) {
		if(record[idx_1][idx_2] != null) return record[idx_1][idx_2];

		int length = 0;
		int targetNum = arr[idx_1] + arr[idx_2];
		for(int curIdx = idx_2 + 1; curIdx < arr.length && arr[curIdx] <= targetNum; curIdx++) {
			if(arr[curIdx] == targetNum) {
				length = arr[idx_2] + arr[curIdx] <= arr[arr.length - 1] ? 1 + recursion(idx_2, curIdx, arr, record) : 1;
				break;
			}
		}
		record[idx_1][idx_2] = length;
		return length;
	}
	public int lenLongestFibSubseq(int[] arr) {
		int max = arr[arr.length - 1];
		int maxLength = 0;
		Integer[][] record = new Integer[arr.length][arr.length];
		for(int i = 0; i < arr.length - 2 && arr[i] * 2 + 1 <= max; i++) {
			for(int j = i + 1; j < arr.length - 1 && arr[i] + arr[j] <= max; j++) {
				if(record[i][j] == null) {
					recursion(i, j, arr, record);
					maxLength = Math.max(maxLength, record[i][j]);
				}
			}
		}

		return maxLength != 0 ? maxLength + 2 : maxLength;
	}
}
