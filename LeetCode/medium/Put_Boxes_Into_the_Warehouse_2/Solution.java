package medium.Put_Boxes_Into_the_Warehouse_2;

import java.util.Arrays;

/**
 * Runtime : 15ms(100.00%%)
 * Memory : 51.8mb(47.17%)
 * Time Complexity : O(n)
 * Subject : Greedy
 */
public class Solution {
	public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
		Arrays.sort(boxes);
		int boxIdx = boxes.length - 1;
		int leftIdx = 0;
		int rightIdx = warehouse.length - 1;
		int leftMinHeight = warehouse[leftIdx];
		int rightMinHeight = warehouse[rightIdx];

		int storedBoxCnt = 0;

		while(0 <= boxIdx && leftIdx <= rightIdx) {
			int boxHeight = boxes[boxIdx];
			if(boxHeight <= leftMinHeight) {
				storedBoxCnt++;
				leftIdx++;
				if(leftIdx <= rightIdx) leftMinHeight = Math.min(leftMinHeight, warehouse[leftIdx]);
			} else if(boxHeight <= rightMinHeight) {
				storedBoxCnt++;
				rightIdx--;
				if(leftIdx <= rightIdx)rightMinHeight = Math.min(rightMinHeight, warehouse[rightIdx]);
			}
			boxIdx--;
		}
		return storedBoxCnt;
	}
}
