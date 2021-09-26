package medium.Maximum_Score_From_Removing_Substrings;

import org.junit.Test;

/**
 * Runtime : 25ms(86.90%)
 * Memory : 51.5mb(20.00%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		String s = "cdbcbbaaabab"; int x = 4; int y = 5;
		String s = "aabbaaxybbaabb"; int x = 5; int y = 4;
		System.out.println(maximumGain(s, x, y));
	}
	public int maximumGain(String s, int x, int y) {
		int openStack = 0, closeStack = 0, gain = 0;
		int openScore = Math.max(x, y), closeScore = Math.min(x, y);
		char openChar = x > y ? 'a' : 'b', closeChar = x > y ? 'b' : 'a';

		for(char ch : s.toCharArray()) {
			if(ch == openChar) {
				openStack++;
			} else if(ch == closeChar) {
				closeStack++;
				if(openStack > 0) {
					openStack--;
					closeStack--;
					gain += openScore;
				}
			} else {
				gain += Math.min(openStack, closeStack) * closeScore;
				openStack = 0;
				closeStack = 0;
			}
		}
		gain += Math.min(openStack, closeStack) * closeScore;

		return gain;
	}
}