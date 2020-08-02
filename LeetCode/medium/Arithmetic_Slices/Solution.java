package medium.Arithmetic_Slices;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] A = new int[]{1, 3, 5, 7, 9};
		System.out.println(numberOfArithmeticSlices(A));
	}
	private int recursion(int idx, int gap, int cnt, int[] arr) {
		for(int i = idx + 1; i < arr.length && arr[i] - arr[idx] <= gap; i++) {
			if(arr[i] - arr[idx] == gap) {
				return cnt >= 2 ? 1 + recursion(i, gap, cnt + 1, arr) : recursion(i, gap, cnt + 1, arr);
			}
		}
		return 0;
	}

	public int numberOfArithmeticSlices(int[] A) {
		int result = 0;
		for(int i = 0; i <= A.length - 3; i++) {
			for(int j = i + 1; j <= A.length - 2 && A[j] + A[j] - A[i] <= A[A.length - 1]; j++) {
				result += recursion(j, A[j] - A[i], 2, A);
			}
		}
		return result;
	}
}
