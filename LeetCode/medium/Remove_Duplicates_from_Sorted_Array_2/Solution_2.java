package medium.Remove_Duplicates_from_Sorted_Array_2;

/**
 * Time Complexity: O(n)
    * 0 ms Beats 100.00%
 * Space Complexity : O(1)
    * 44.25 MB Beats 89.34%
 */
public class Solution_2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int storeIdx = 1;
        int duplicateCnt = 1;

        for (int curIdx = 1; curIdx < nums.length; curIdx++) {
            if (nums[curIdx] != nums[curIdx - 1]) {
                duplicateCnt = 1;
            } else {
                duplicateCnt++;
            }

            if (duplicateCnt <= 2) {
                nums[storeIdx++] = nums[curIdx];
            }
        }
        return storeIdx;
    }
}
