package hard.Largest_Rectangle_in_Histogram;

import org.junit.Test;

/**
 * Runtime : 2ms(95.04%)
 * Memory : 41mb(51.57%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] heights = new int[]{2,1,5,6,2,3};
		int[] heights = new int[]{2,1,0,2};
		System.out.println(largestRectangleArea(heights));
	}
	private int recursion(int left, int right, int[] height) {
		if(left == right) return height[left];

		int m = (left + right) / 2;
		int leftMax = recursion(left, m, height);
		int rightMax = recursion(m + 1, right, height);
		int midMax = getMidMax(left, right, height);

		return Math.max(midMax, Math.max(leftMax, rightMax));
	}

	private int getMidMax(int left, int right, int[] height) {
		int leftP = (left + right) / 2;
		int rightP = leftP + 1;

		int len = 2;
		int curHeight = Math.min(height[leftP--], height[rightP++]);
		int maxSize = curHeight * len++;

		while(left <= leftP || rightP <= right) {
			if(right < rightP|| (left <= leftP && height[rightP] <= height[leftP])) {
				curHeight = Math.min(curHeight, height[leftP--]);
				maxSize = Math.max(maxSize, curHeight * len++);
			} else if(leftP < left || (rightP <= right && height[leftP] < height[rightP])) {
				curHeight = Math.min(curHeight, height[rightP++]);
				maxSize = Math.max(maxSize, curHeight * len++);
			}
		}

		return maxSize;
	}

	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) return 0;
		else if(heights.length == 1) return heights[0];
		return recursion(0, heights.length - 1, heights);
	}
}
