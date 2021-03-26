package medium.Put_Boxes_Into_the_Warehouse_I;

import java.util.Arrays;

/**
 * Runtime : 15ms(96.39%)
 * Memory : 51.7mb(74.70%)
 * Time Complexity : O(n)
 * Subject : Greedy
 */
public class Solution {
	public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
		Arrays.sort(boxes);
		int boxIdx = boxes.length - 1;
		int houseIdx = 0;
		int minHeight = 1000000001;

		int storedBoxCnt = 0;

		while(0 <= boxIdx && houseIdx < warehouse.length) {
			minHeight = Math.min(minHeight, warehouse[houseIdx++]);
			while(0 <= boxIdx && minHeight < boxes[boxIdx]) boxIdx--;
			if(boxIdx == -1) break;
			storedBoxCnt++;
			boxIdx--;
		}
		return storedBoxCnt;
	}
}
