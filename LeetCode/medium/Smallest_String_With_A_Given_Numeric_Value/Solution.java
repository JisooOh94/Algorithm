package medium.Smallest_String_With_A_Given_Numeric_Value;

import org.junit.Test;

/**
 * Runtime : 26ms(40.43%)
 * Memory : 38.9mb(85.60%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int n = 5;
		int sum = 73;
		System.out.println(getSmallestString(n, sum));
	}

	private static final int MAX_VAL = 26;
	public String getSmallestString(int n, int sum) {
		StringBuilder builder = new StringBuilder();

		int left = n;
		for(int i = 0; i < n - 1; i++) {
			int inSuff = sum - 1 - (left-- - 1) * MAX_VAL;
			if(inSuff <= 0) {
				sum -= 1;
				builder.append('a');
			} else {
				sum -= 1 + inSuff;
				builder.append((char)('a' + inSuff));
				for(int j = i + 1; j < n - 1; j++) {
					sum -= MAX_VAL;
					builder.append((char)(MAX_VAL - 1 + 'a' ));
				}
				break;
			}
		}
		builder.append((char)(sum - 1 + 'a'));
		return builder.toString();
	}
}
