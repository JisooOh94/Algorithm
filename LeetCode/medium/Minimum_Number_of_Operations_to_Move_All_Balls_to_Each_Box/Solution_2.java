package medium.Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 3ms(66.67%)
 * Memory : 39.3mb(83.33%)
 * Time Complexity : O(n)
 * Subject : Greedy
 */
public class Solution_2 {
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final char BALL = '1';
	public int[] minOperations(String str) {
		int[] minOperation = new int[str.length()];
		int[] distance = new int[2];
		int[] ballCnt = new int[2];
		boolean onMid;

		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == BALL) {
				ballCnt[RIGHT]++;
				distance[RIGHT] += i;
			}
		}

		onMid = str.charAt(0) == BALL;
		minOperation[0] = distance[RIGHT];

		for(int i = 1; i < str.length(); i++) {
			if(onMid) {
				ballCnt[LEFT]++;
				onMid = false;
			}
			distance[LEFT] += ballCnt[LEFT];
			distance[RIGHT] -= ballCnt[RIGHT];
			minOperation[i] = distance[LEFT] + distance[RIGHT];
			if(str.charAt(i) == BALL) {
				ballCnt[RIGHT]--;
				onMid = true;
			}
		}

		return minOperation;
	}
}
