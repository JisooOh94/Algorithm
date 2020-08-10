package medium.Integer_Break;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36mb(85.99%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 2;
		System.out.println(integerBreak(n));
	}
	private int recursion(int num, int[] record) {
		if(record[num] != 0) return record[num];
		int max = 1;
		for(int i = 1; i <= num; i++) {
			max = Math.max(max, i * recursion(num - i, record));
		}
		record[num] = max;
		return max;
	}

	public int integerBreak(int num) {
		int[] record = new int[num + 1];

		int max = 1;
		for(int i = 1; i < num; i++) {
			max = Math.max(max, i * recursion(num - i, record));
		}

		return max;
	}
}
