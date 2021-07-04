package medium.Max_Chunks_To_Make_Sorted;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.5mb(29.83%)
 * Time Complexity : O(n^2)
 * Subject : greedy
 */
public class Solution {
	public int maxChunksToSorted(int[] arr) {
		int chunkSize = 0;
		int fromIdx = 0;
		while(fromIdx < arr.length) {
			int toidx = fromIdx;
			int maxVal = arr[fromIdx];
			int chunkMaxVal = 0;
			for(int i = fromIdx + 1; i < arr.length; i++) {
				if (arr[i] < arr[fromIdx]) {
					toidx = i;
					chunkMaxVal = maxVal;
				} else if(arr[i] < chunkMaxVal) {
					toidx = i;
					chunkMaxVal = maxVal;
				}

				maxVal = Math.max(maxVal, arr[i]);
			}
			fromIdx = toidx + 1;
			chunkSize++;
		}
		return chunkSize;
	}
}
