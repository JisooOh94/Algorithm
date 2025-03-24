package medium.Remove_Duplicates_from_Sorted_Array_2;

/**
 * Time Complexity: O(n)
    * 0 ms Beats 100.00%
 * Space Complexity : O(1)
    * 44.17 MB Beats 94.76%
 */
public class Solution_1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int storeIdx = 2;

        for (int curIdx = 2; curIdx < nums.length; curIdx++) {
            if (nums[curIdx] != nums[curIdx - 2]) {
                if (curIdx + 1 < nums.length && nums[curIdx] == nums[curIdx + 1] && nums[curIdx] != nums[curIdx - 1]) {
                    nums[storeIdx++] = nums[curIdx];
                    nums[storeIdx++] = nums[curIdx];
                    curIdx++;
                } else {
                    nums[storeIdx++] = nums[curIdx];
                }
            }
        }

        return storeIdx;
    }


}
