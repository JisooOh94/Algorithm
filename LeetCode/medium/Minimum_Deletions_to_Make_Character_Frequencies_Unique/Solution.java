package medium.Minimum_Deletions_to_Make_Character_Frequencies_Unique;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Runtime : 10ms(88.08%)
 * Memory : 39.3mb(97.55%)
 * TimeComplexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int minDeletions(String s) {
		int[] countArr = new int[26];
		for(char ch : s.toCharArray()) {
			countArr[ch - 'a']++;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int count : countArr) {
			if(count != 0) {
				queue.offer(count);
			}
		}

		int deleteCnt = 0;
		int validVal = queue.poll() - 1;
		while(!queue.isEmpty()) {
			int curVal = queue.poll();
			if(curVal > validVal) {
				deleteCnt += curVal - validVal;
				if(validVal != 0) validVal--;
			} else {
				validVal = curVal - 1;
			}
		}

		return deleteCnt;
	}
}
