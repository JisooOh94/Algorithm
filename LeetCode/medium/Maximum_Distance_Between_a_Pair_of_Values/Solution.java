package medium.Maximum_Distance_Between_a_Pair_of_Values;

/**
 * Runtime : 2ms(99.56%)
 * Memory : 51.9mb(65.60%)
 * Time Complexity : O(n * m)
 * Subject : Greedy
 */
public class Solution {
	public int maxDistance(int[] nums1, int[] nums2) {
		int maxGap = 0;
		for(int idx_1 = 0; idx_1 < nums1.length && idx_1 + maxGap + 1 < nums2.length; idx_1++) {
			for(int idx_2 = idx_1 + maxGap + 1; idx_2 < nums2.length && nums1[idx_1] <= nums2[idx_2]; idx_2++) {
				maxGap++;
			}
		}
		return maxGap;
	}
}
