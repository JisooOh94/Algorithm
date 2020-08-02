package medium.Arithmetic_Slices;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.5mb(17.00%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] A = new int[]{1,2,3,4,5,6};
		System.out.println(numberOfArithmeticSlices(A));
	}

	public int numberOfArithmeticSlices(int[] arr) {
		int[] record = new int[arr.length];
		int count = 0;
		for(int i = 2; i < arr.length; i++) {
			if(arr[i - 1] - arr[i - 2] == arr[i] - arr[i - 1]) record[i] = record[i - 1] + 1;
			count += record[i];
		}
		return count;
	}
}
