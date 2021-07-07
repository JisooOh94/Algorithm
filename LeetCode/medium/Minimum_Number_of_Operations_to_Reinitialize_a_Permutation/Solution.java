package medium.Minimum_Number_of_Operations_to_Reinitialize_a_Permutation;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 35.8mb(81.28%)
 * Time Complexity : O(1)
 */
public class Solution {
	public int reinitializePermutation(int n) {
		int num = 1;
		int cnt = 0;
		do {
			num = num % 2 == 0 ? num / 2 : n / 2 + (num - 1) / 2;
			cnt++;
		} while(num != 1);
		return cnt;
	}
}
