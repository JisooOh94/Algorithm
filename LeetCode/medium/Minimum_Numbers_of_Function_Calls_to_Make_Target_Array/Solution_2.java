package medium.Minimum_Numbers_of_Function_Calls_to_Make_Target_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime : 127ms(5.55%)
 * Memory : 47.3mb(27.16%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution_2 {
	private static final int PLUS = 0;
	private static final int MULT = 1;
	private int[] recursion(int num, Map<Integer, int[]> memoization) {
		if(num == 0) return new int[]{0,0};

		if(memoization.containsKey(num)) return memoization.get(num).clone();

		int[] result;
		if(num % 2 == 0) {
			result = recursion(num / 2, memoization);
			result[MULT]++;
		} else {
			result = recursion(num - 1, memoization);
			result[PLUS]++;
		}

		return result;
	}

	public int minOperations(int[] nums) {
		int plusSum = 0;
		int maxMult = 0;
		Map<Integer, int[]> memoization = new HashMap<>();

		for(int num : nums) {
			int[] result = recursion(num, memoization);
			plusSum += result[PLUS];
			maxMult = Math.max(maxMult, result[MULT]);
		}
		return plusSum + maxMult;
	}
}
