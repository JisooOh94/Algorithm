package medium.Maximum_Score_From_Removing_Stones;

import java.util.Arrays;

/**
 * Runtime : 12ms(68.64%)
 * Memory : 35.6mb(87.77%)
 * Time Complexity : O(Max(n))
 * Subject : greedy
 */
public class Solution {
	public int maximumScore(int a, int b, int c) {
		int[] arr = new int[]{a,b,c};
		int score = 0;
		while(true) {
			Arrays.sort(arr);
			if(arr[1] == 0) break;
			arr[1]--;
			arr[2]--;
			score++;
		}
		return score;
	}
}
