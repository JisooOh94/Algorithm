package medium.Minimum_Numbers_of_Function_Calls_to_Make_Target_Array;

/**
 * Runtime : 70ms(25.31%)
 * Memory : 46.7mb(91.98%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int minOperations(int[] nums) {
		int plusSum = 0;
		int maxMult = 0;
		for(int num : nums) {
			int curMult = 0;
			while(0 < num) {
				if(num % 2 == 0) {
					num /= 2;
					curMult++;
				} else {
					num -= 1;
					plusSum++;
				}
			}
			maxMult = Math.max(maxMult, curMult);
		}
		return plusSum + maxMult;
	}
}
