package medium.House_Robber;

public class Solution_1 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return recursion(0, nums);
    }

    private int recursion(int startIdx, int[] nums) {
        if (startIdx >= nums.length) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = startIdx; i < nums.length; i++) {
            int sum = nums[i] + recursion(i + 2, nums);
            maxSum = Integer.max(sum, maxSum);
        }

        return maxSum;
    }
}
