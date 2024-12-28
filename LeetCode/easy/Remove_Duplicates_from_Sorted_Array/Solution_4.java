package easy.Remove_Duplicates_from_Sorted_Array;

/**
 * Time Complexity: O(n)
    * 0 ms Beats 100.00%
 * Space Complexity : O(1)
    * 44.68 MB Beats 75.96%
 */
public class Solution_4 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int storeIdx = 1;

        for (int curIdx = 1; curIdx < nums.length; curIdx++) {
            if (nums[curIdx] != nums[curIdx - 1]) {
                nums[storeIdx++] = nums[curIdx];
            }
        }
        return storeIdx;
    }
}
