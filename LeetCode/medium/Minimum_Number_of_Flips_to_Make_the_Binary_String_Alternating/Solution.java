package medium.Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating;

import org.junit.Test;

/**
 * Runtime : 18ms(89.60%)
 * Memory : 39.7mb(69.94%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		String s = "111000";
		System.out.println(minFlips(s));
	}

	public int minFlips(String s) {
		int[][] cnt = new int[2][s.length()];
		cnt[s.charAt(0) == '0' ? 1 : 0][0] = 1;

		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) != (char)(i % 2 + '0')) {
				cnt[0][i] = cnt[0][i - 1] + 1;
				cnt[1][i] = cnt[1][i - 1];
			} else {
				cnt[0][i] = cnt[0][i - 1];
				cnt[1][i] = cnt[1][i - 1] + 1;
			}
		}

		int maxFlip_0 = cnt[0][s.length() - 1];
		int maxFlip_1 = cnt[1][s.length() - 1];

		int minFlip = Math.min(maxFlip_0, maxFlip_1);

		for(int i = 0; i < s.length() - 1; i++) {
			int startIdx = i + 1;
			int endIdx = i;

			int flipCnt_0 = (maxFlip_0 - cnt[0][startIdx - 1]) + cnt[s.length() % 2 == 0 ? 0 : 1][endIdx];
			int flipCnt_1 = (maxFlip_1 - cnt[1][startIdx - 1]) + cnt[s.length() % 2 == 0 ? 1 : 0][endIdx];

			minFlip = Math.min(minFlip, Math.min(flipCnt_0 , flipCnt_1));
		}
		return minFlip;
	}
}
