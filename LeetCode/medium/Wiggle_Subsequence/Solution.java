package medium.Wiggle_Subsequence;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.1mb(37.46%)
 */
public class Solution {
    @Test
    public void test() {
        //int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        //int[] nums = new int[]{2, 2, 2, 2, 2, 2, 2, 3};
        //int[] nums = new int[]{1,7,4,9,2,5};
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.print(wiggleMaxLength(nums));
    }

    private boolean isWiggler(int[] nums, int nIdx, int nnIdx, int dir) {
        if(dir == -1 && nums[nnIdx] < nums[nIdx]) return true;
        else if(dir == 1 && nums[nIdx] < nums[nnIdx]) return true;
        return false;
    }

    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int remainCnt = 1;
        int nIdx = 1;
        while (true) {
            if (nIdx == nums.length) return remainCnt;
            else if (nums[0] != nums[nIdx]) break;
            nIdx++;
        }

        int nnIdx = nIdx + 1;
        int dir = nums[0] < nums[nIdx] ? -1 : 1;

        while (true) {
            if (nnIdx == nums.length) break;

            if (isWiggler(nums, nIdx, nnIdx, dir)) {
                nIdx = nnIdx;
                nnIdx++;
                remainCnt++;
                dir *= -1;
            } else {
                nIdx = nnIdx;
                nnIdx++;
            }
        }

        return remainCnt + 1;
    }
}
