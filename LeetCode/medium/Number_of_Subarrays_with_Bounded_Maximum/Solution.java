package medium.Number_of_Subarrays_with_Bounded_Maximum;

public class Solution {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		int totalCnt = 0, prev = 0, cand = 0, totalCand = 0;
		for(int num : nums) {
			if(left <= num && num <= right) {
				prev += 1;
				totalCnt += totalCand;
				totalCand = cand = 0;
			}
			else if(num < left) {
				cand += 1;
				totalCand += cand;
			}
			else {
				prev = 0;
				totalCand = cand = 0;
			}
			totalCnt += prev;
		}
		totalCnt += prev;
		return totalCnt;
	}
}
