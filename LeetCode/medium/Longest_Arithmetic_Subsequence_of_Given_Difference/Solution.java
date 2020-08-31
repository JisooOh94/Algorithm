package medium.Longest_Arithmetic_Subsequence_of_Given_Difference;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
//		int[] arr = new int[]{1,2,3,4}; int diff = 1;
//		int[] arr = new int[]{1,3,5,7}; int diff = 1;
//		int[] arr = new int[]{1,5,7,8,5,3,4,2,1}; int diff = -2;
		int[] arr = new int[]{3,4,-3,-2,-4}; int diff = -5;
		System.out.println(longestSubsequence(arr, diff));
	}
	private int recursion(int[] arr, int idx, int gap, Integer[] record) {
		if(idx == arr.length - 1) return 1;
		else if(record[idx] != null) return record[idx];
		int target = arr[idx] + gap;
		int length = 1;
		for(int i = idx + 1; i < arr.length; i++) {
			if(arr[i] == target) {
				length += recursion(arr, i, gap, record);
				break;
			}
		}

		record[idx] = length;
		return length;
	}
	public int longestSubsequence(int[] arr, int difference) {
		int maxLength = 0;
		Integer[] record = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) {
			maxLength = Math.max(maxLength, recursion(arr, i, difference, record));
		}
		return maxLength;
	}
}
