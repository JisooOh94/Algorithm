package medium.Minimum_Increment_to_Make_Array_Unique;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime : 122ms(10.09%)
 * Memory : 60.3mb(5.76%)
 * Time Complexity : O(n)
 * Subject : union find
 */
public class another {
	public int minIncrementForUnique(int[] arr) {
		Map<Integer, Integer> uniqueValueMap = new HashMap<>();
		int plusSum = 0;
		for(int val : arr) plusSum += find(val, uniqueValueMap) - val;
		return plusSum;
	}

	private int find(int val, Map<Integer, Integer> roots){
		int uniqueVal = roots.containsKey(val) ? find(roots.get(val) + 1, roots) : val;
		roots.put(val, uniqueVal);
		return uniqueVal;
	}
}
