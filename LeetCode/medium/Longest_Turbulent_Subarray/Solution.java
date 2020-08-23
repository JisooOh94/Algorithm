package medium.Longest_Turbulent_Subarray;

import org.junit.Test;

/**
 * Runtime : 5ms(71.09%)
 * Memory : 43mb(78.96%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] arr = new int[]{9,4,2,10,7,8,8,1,9};
//		int[] arr = new int[]{4,8,12,16};
//		int[] arr = new int[]{100};
//		int[] arr = new int[]{9, 9};
		int[] arr = new int[]{0,8,45,88,48,68,28,55,17,24};
		System.out.println(maxTurbulenceSize(arr));
	}
	public int maxTurbulenceSize(int[] arr) {
		if(arr.length < 2) return arr.length;
		int prevDir = arr[1] == arr[0] ? 0 : (arr[1] - arr[0]) / Math.abs(arr[1] - arr[0]);
		int curLen = prevDir == 0 ? 1 : 2;
		int maxLen = curLen;

		for(int i = 1; i < arr.length - 1; i++) {
			int curDir = arr[i + 1] == arr[i] ? 0 : (arr[i + 1] - arr[i]) / Math.abs(arr[i + 1] - arr[i]);
			if(curDir == prevDir || curDir == 0) {
				maxLen = Math.max(maxLen, curLen);
				curLen = curDir == 0 ? 1 : 2;
			} else {
				curLen++;
			}
			prevDir = curDir;
		}

		return Math.max(maxLen, curLen);
	}
}
