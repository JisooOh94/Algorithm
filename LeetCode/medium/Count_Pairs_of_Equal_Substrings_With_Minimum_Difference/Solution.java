package medium.Count_Pairs_of_Equal_Substrings_With_Minimum_Difference;

/**
 * Runtime : 808ms(100.00%)
 * Memory : 40.8mb(100.00%)
 * Time Complexity : O(n^2)
 * Subject : Greedy
 */
public class Solution {
	public int countQuadruples(String firstString, String secondString) {
		int maxGap = 0;
		int maxGapCnt = 0;

		for(int i = 0; i < firstString.length(); i++) {
			if(secondString.length() - i == maxGap) break;
			for(int j = i + maxGap; j < secondString.length(); j++) {
				if(firstString.charAt(i) == secondString.charAt(j)) {
					if(j - i > maxGap) {
						maxGap = j - i;
						maxGapCnt = 0;
					}
					maxGapCnt++;
				}
			}
		}
		return maxGapCnt;
	}
}
