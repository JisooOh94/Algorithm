package medium.Frequency_of_the_Most_Frequent_Element;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 28ms(47.57%)
 * Memory : 55.6mb(44.27%)
 * Time Complexity : O(n)
 * Subject : greedy, sliding windows
 */
public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{1,2}; int k = 5;
		int[] nums = new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966}; int k = 3056;

		System.out.println(maxFrequency(nums, k));
	}
	public int maxFrequency(int[] nums, int have) {
		Arrays.sort(nums);

		int elemCnt = 0, maxElemCnt = 0, frontIdx = 0, rearIdx = 0, need = 0;

		while(frontIdx < nums.length - 1) {
			int curNeed = (nums[frontIdx + 1] - nums[frontIdx]) * (elemCnt + 1);
			if(need + curNeed <= have) {
				need += curNeed;
				frontIdx++;
				elemCnt++;
				maxElemCnt = Math.max(maxElemCnt, elemCnt);
			} else {
				if(rearIdx < frontIdx) {
					need -= nums[frontIdx] - nums[rearIdx];
					elemCnt--;
				} else {
					frontIdx++;
				}
				rearIdx++;
			}
		}
		return maxElemCnt + 1;
	}
}