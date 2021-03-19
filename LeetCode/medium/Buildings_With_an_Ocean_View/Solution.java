package medium.Buildings_With_an_Ocean_View;

import java.util.LinkedList;

/**
 * Runtime : 7ms(100.0%)
 * Memory : 55.5mb(100.00%)
 * Time Complexity : O(n)
 * Subject : Greedy
 */
public class Solution {
	public int[] findBuildings(int[] heights) {
		LinkedList<Integer> oceanViewIdx = new LinkedList<>();
		int maxHeight = -1;
		for(int i = heights.length - 1; 0 <= i; i--) {
			if(maxHeight < heights[i]) {
				maxHeight = heights[i];
				oceanViewIdx.addFirst(i);
			}
		}
		return oceanViewIdx.stream().mapToInt(i->i).toArray();
	}
}
