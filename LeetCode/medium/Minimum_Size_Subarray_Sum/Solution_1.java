package medium.Minimum_Size_Subarray_Sum;

/**
 * Time Complexity : O(n)
     * 1 ms Beats 99.91%
 * Space Complexity : O(1)
    * 57.67 MB Beats 87.98%
 */
public class Solution_1 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return target <= nums[0] ? 1 : 0;
        }

        int frontIdx = 0;
        int rearIdx = 0;
        int curSum = 0;
        int curLen = 0;
        int minLen = Integer.MAX_VALUE;

        while (rearIdx < nums.length) {
            curSum += nums[rearIdx++];
            curLen++;

            if (target <= curSum) {
                minLen = Math.min(curLen, minLen);

                while (frontIdx < rearIdx) {
                    curSum -= nums[frontIdx++];
                    curLen--;

                    if (target <= curSum) {
                        minLen = Math.min(curLen, minLen);
                    } else {
                        break;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
