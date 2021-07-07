package medium.Merge_Triplets_to_Form_Target_Triplet;

/**
 * Runtime : 2ms(89.34%)
 * Memory : 100.8mb(73.81%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public boolean mergeTriplets(int[][] triplets, int[] target) {
		boolean condition_1 = false;
		boolean condition_2 = false;
		boolean condition_3 = false;
		boolean condition_4 = false;

		for(int[] triplet : triplets) {
			boolean curCondition_1 = triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2];

			boolean curCondition_2 = triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2];
			boolean curCondition_3 = triplet[1] == target[1] && triplet[0] <= target[0] && triplet[2] <= target[2];
			boolean curCondition_4 = triplet[2] == target[2] && triplet[0] <= target[0] && triplet[1] <= target[1];

			condition_1 = condition_1 || curCondition_1;
			condition_2 = condition_2 || curCondition_2;
			condition_3 = condition_3 || curCondition_3;
			condition_4 = condition_4 || curCondition_4;

			if(condition_1 && condition_2 && condition_3 && condition_4) return true;
		}
		return false;
	}
}
