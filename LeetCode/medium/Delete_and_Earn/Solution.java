package medium.Delete_and_Earn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 3ms(63.25 % )
 * Memory : 38.9mb(93.80%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{3, 4, 2};
		int[] nums = new int[]{2, 2, 3, 3, 3, 4};
		System.out.println(deleteAndEarn(nums));
	}
	private int recursion(int curIdx, List<int[]> nums, Integer[] record) {
		if(nums.size() - 1 == curIdx) return nums.get(curIdx)[1];
		else if(nums.size() <= curIdx) return 0;
		else if(record[curIdx] != null) return record[curIdx];

		int curScore = 0;
		if(nums.get(curIdx)[0] - nums.get(curIdx + 1)[0] == -1) {
			curScore = Math.max(nums.get(curIdx)[1] + recursion(curIdx + 2, nums, record), recursion(curIdx + 1, nums, record));
		} else {
			curScore = nums.get(curIdx)[1] + recursion(curIdx + 1, nums, record);
		}

		record[curIdx] = curScore;
		return curScore;
	}
	public int deleteAndEarn(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		List<int[]> accum = new ArrayList<>();
		Arrays.sort(nums);
		int num = nums[0];
		int numCnt = 1;

		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != num) {
				accum.add(new int[]{num, num * numCnt});
				numCnt = 1;
				num = nums[i];
			} else {
				numCnt++;
			}
		}
		accum.add(new int[]{num, num * numCnt});
		Integer[] record = new Integer[accum.size()];
		return recursion(0, accum, record);
	}
}
