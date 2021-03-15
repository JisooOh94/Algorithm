package medium.Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 215ms(16.67%)
 * Memory : 39.5mb(66.67%)
 * Time Complexity : O(n^2)
 * Subject : Greedy
 */
public class Solution {
	public int[] minOperations(String boxes) {
		List<Integer> ballIdxList = new LinkedList<>();
		int[] result = new int[boxes.length()];
		for(int i = 0; i < boxes.length(); i++) if(boxes.charAt(i) == '1') ballIdxList.add(i);
		for(int i = 0; i < boxes.length(); i++) {
			for(int ballIdx : ballIdxList) result[i] += Math.abs(ballIdx - i);
		}

		return result;
	}
}
