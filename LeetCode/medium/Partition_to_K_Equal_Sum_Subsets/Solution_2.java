package medium.Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 497ms(10.57%)
 * Memory : 37.3mb(63.52%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(canPartitionKSubsets(nums, k));
	}
	private boolean recursion(int targetSum, int curSum, int leftSubSeq, int startIdx, boolean[] visited, int[] nums) {
		if(leftSubSeq == 0) {
			return true;
		} else if(curSum == targetSum) {
			return recursion(targetSum, 0, leftSubSeq - 1, 0, visited, nums);
		}

		for(int i = startIdx; i < nums.length && nums[i] + curSum <= targetSum; i++) {
			if(visited[i]) continue;

			visited[i] = true;
			if(recursion(targetSum, curSum + nums[i], leftSubSeq, i + 1, visited, nums)) return true;
			visited[i] = false;
		}

		return false;
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		int targetSum = 0;
		int maxNum = 0;
		for(int num : nums) {
			targetSum += num;
			maxNum = Math.max(maxNum, num);
		}

		if (targetSum % k != 0 || maxNum > targetSum / k) {
			return false;
		}

		targetSum /= k;

		boolean[] visited = new boolean[nums.length];

		return recursion(targetSum, 0, k, 0, visited, nums);
	}
}
