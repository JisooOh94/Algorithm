package medium.House_Robber;

/**
 * Time Complexity : O(n)
    * 0ms Beats 100.00%
 * Space Complexity : O(n)
    * 41.15MB Beats 39.79%
 */
public class Solution_2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Integer[] memoization = new Integer[nums.length];
        return recursion(0, nums, memoization);
    }

    private int recursion(int startIdx, int[] nums, Integer[] memoization) {
        if (startIdx >= nums.length) {
            return 0;
        }

        if (memoization[startIdx] != null) {
            return memoization[startIdx];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = startIdx; i < nums.length; i++) {
            int sum = nums[i] + recursion(i + 2, nums, memoization);
            maxSum = Integer.max(sum, maxSum);
        }

        memoization[startIdx] = maxSum;

        return maxSum;
    }
}
