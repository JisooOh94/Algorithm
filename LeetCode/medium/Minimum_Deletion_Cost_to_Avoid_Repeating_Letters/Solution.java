package medium.Minimum_Deletion_Cost_to_Avoid_Repeating_Letters;

/**
 * Runtime : 6ms(90.88%)
 * Memory : 56.8mb(62.53%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int minCost(String s, int[] cost) {
		char prevWord = s.charAt(0);
		int prevCost = cost[0];
		int totalCost = 0;

		for(int i = 1; i < s.length(); i++) {
			char curWord = s.charAt(i);
			int curCost = cost[i];
			if(prevWord == curWord) {
				totalCost += Math.min(prevCost, curCost);
				prevCost = Math.max(prevCost, curCost);
			} else {
				prevCost = curCost;
			}

			prevWord = curWord;
		}
		return totalCost;
	}
}
