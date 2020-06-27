package medium.Bag_of_Tokens;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 3ms(83.57%)
 * Memory : 38.8mb(97.11%)
 */
public class Solution {
	@Test
	public void execute() {
		//int[] tokens = new int[]{100}; int power = 50;
		//int[] tokens = new int[]{100, 200}; int power = 150;
		//int[] tokens = new int[]{100, 200, 300, 400}; int power = 200;
		int[] tokens = new int[]{4903,8812,6101,4671,6323,3378,1243,6825,6220,7885,1271,9117,7993,9168,8725}; int power = 6810;
		System.out.println(bagOfTokensScore(tokens, power));
	}
	public int bagOfTokensScore(int[] tokens, int power) {
		if(tokens == null || tokens.length == 0) return 0;

		Arrays.sort(tokens);
		if(power == 0 && tokens[0] != 0) return 0;

		int frontIdx = 0;
		int rearIdx = tokens.length - 1;

		int maxScore = 0;
		int score = 0;

		while(true) {
			if(rearIdx < frontIdx) break;
			if(tokens[frontIdx] <= power) {
				power -= tokens[frontIdx++];
				score++;
				if(maxScore < score) maxScore = score;
			} else {
				if(score == 0) break;
				power += tokens[rearIdx--];

				score --;
			}
		}

		return maxScore;
	}
}
