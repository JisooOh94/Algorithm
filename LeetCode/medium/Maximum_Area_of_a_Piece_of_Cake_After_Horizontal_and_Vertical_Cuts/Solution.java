package medium.Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts;

import java.util.Arrays;

/**
 * Runtime : 13ms(90.56%)
 * Memory : 48.9mb(71.56%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int hMax = 0;
		int vMax = 0;

		int hPrev = 0;
		Arrays.sort(horizontalCuts);
		for(int hCut : horizontalCuts) {
			hMax = Math.max(hMax, hCut - hPrev);
			hPrev = hCut;
		}
		hMax = Math.max(hMax, h - hPrev);

		int vPrev = 0;
		Arrays.sort(verticalCuts);
		for(int vCut : verticalCuts) {
			vMax = Math.max(vMax, vCut - vPrev);
			vPrev = vCut;
		}
		vMax = Math.max(vMax, w - vPrev);

		return (int)(((long)hMax * (long)vMax) % ((long)Math.pow(10, 9) + (long)7));
	}
}
