package medium.Longest_Arithmetic_Subsequence_of_Given_Difference;

import java.util.HashMap;

import org.junit.Test;

/**
 * Runtime : 35ms(96.79%)
 * Memory : 56.4mb(66.56%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[] arr = new int[]{1,2,3,4}; int diff = 1;
//		int[] arr = new int[]{1,3,5,7}; int diff = 1;
//		int[] arr = new int[]{1,5,7,8,5,3,4,2,1}; int diff = -2;
		int[] arr = new int[]{3,4,-3,-2,-4}; int diff = -5;
		System.out.println(longestSubsequence(arr, diff));
	}

	public int longestSubsequence(int[] arr, int difference) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		int maxLength = 0;
		for(int i = 0; i < arr.length; i++) {
			int curLength = memo.getOrDefault(arr[i] - difference, 0) + 1;
			memo.put(arr[i], curLength);
			maxLength = Math.max(maxLength, curLength);
		}

		return maxLength;
	}
}
