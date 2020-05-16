package Container_With_Most_Water;

import util.Predicate;

public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return maxArea((int[])params[0]);
	}

	public int maxArea(int[] height) {
		int maxArea = 0;
		for(int i = 0; i < height.length; i++) {
			int forwardIdx = height.length - 1;
			while(forwardIdx > i) {
				if(height[forwardIdx] >= height[i]) {
					int area = height[i] * (forwardIdx - i);
					if(area > maxArea) {
						maxArea = area;
					}
					break;
				}
				forwardIdx--;
			}

			int backIdx = height.length -1 -i;
			int backwardIdx = 0;
			while(backwardIdx < backIdx) {
				if(height[backwardIdx] >= height[backIdx]) {
					int area = height[backIdx] * (backIdx - backwardIdx);
					if(area > maxArea) {
						maxArea = area;
					}
					break;
				}
				backwardIdx++;
			}
		}

		return maxArea;
	}
}
