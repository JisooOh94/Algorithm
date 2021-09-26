package medium.Minimum_Number_of_Swaps_to_Make_the_String_Alternating;

/**
 * Runtime : 1ms(95.98%)
 * Memory : 37.2mb(78.16%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int minSwaps(String s) {
		int[] pos_1 = new int[]{'1', '0'};
		int[] pos_2 = new int[]{'0', '1'};
		int[] invalidCnt_1 = new int[2];
		int[] invalidCnt_2 = new int[2];

		for(int i = 0; i < s.length(); i++) {
			int posIdx = i % 2;
			if(s.charAt(i) != pos_1[posIdx]) invalidCnt_1[posIdx]++;
			if(s.charAt(i) != pos_2[posIdx]) invalidCnt_2[posIdx]++;
		}

		if(invalidCnt_1[0] != invalidCnt_1[1] && invalidCnt_2[0] != invalidCnt_2[1]) return -1;
		else if(invalidCnt_1[0] != invalidCnt_1[1]) return invalidCnt_2[0];
		else if(invalidCnt_2[0] != invalidCnt_2[1]) return invalidCnt_1[0];
		else return Math.min(invalidCnt_1[0], invalidCnt_2[0]);
	}
}
