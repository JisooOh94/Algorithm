package medium.Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;

import org.junit.Test;
import util.PerformanceUtil;

public class Answer {
	@Test
	public void execute() {
		int[] nums = new int[]{4, 3, 2, 33, 21, 16, 24, 8, 3, 10, 19, 38, 35, 33, 20, 4};
		int k = 7;
		PerformanceUtil.beforeTest();
		System.out.println(canPartitionKSubsets(nums, k));
		System.out.println(PerformanceUtil.afterTest());
	}
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0, maxNum = 0;
		for (int num : nums) {
			sum += num;
			maxNum = Math.max(maxNum, num);
		}
		if (sum % k != 0 || maxNum > sum / k) {
			return false;
		}

//		Arrays.sort(nums);

		return canPartitionKSubsetsFrom_2(nums, k, new boolean[nums.length], sum / k, 0, 0);
	}
	private boolean canPartitionKSubsetsFrom(int[] nums, int k, boolean[] visited, int targetSubsetSum, int curSubsetSum, int nextIndexToCheck) {
		if (k == 0) {
			return true;
		} else if (curSubsetSum == targetSubsetSum) {
			return canPartitionKSubsetsFrom(nums, k - 1, visited, targetSubsetSum, 0, 0);
		}

		for (int i = nextIndexToCheck; i < nums.length; i++) {
			if (!visited[i] && curSubsetSum + nums[i] <= targetSubsetSum) {
				visited[i] = true;
				if (canPartitionKSubsetsFrom(nums, k, visited, targetSubsetSum, curSubsetSum + nums[i], i + 1)) return true;
				visited[i] = false;
			}
		}

		return false;
	}

	private boolean canPartitionKSubsetsFrom_2(int[] nums, int k, boolean[] visited, int targetSubsetSum, int curSubsetSum, int nextIndexToCheck) {
		if (k == 0) {
			return true;
		} else if (curSubsetSum == targetSubsetSum) {
			return canPartitionKSubsetsFrom(nums, k - 1, visited, targetSubsetSum, 0, 0);
		}

		for (int i = nextIndexToCheck; i < nums.length && curSubsetSum + nums[i] <= targetSubsetSum; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (canPartitionKSubsetsFrom(nums, k, visited, targetSubsetSum, curSubsetSum + nums[i], i + 1)) return true;
				visited[i] = false;
			}
		}

		return false;
	}
}
