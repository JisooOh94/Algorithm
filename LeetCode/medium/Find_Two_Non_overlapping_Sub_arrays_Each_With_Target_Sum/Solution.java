package medium.Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] nums = new int[]{1,1,1,5,1,7,2,8,2,9,1,1,1}; int target = 3;
//		int target = 100000000;
//		int[] nums = new int[(int)Math.pow(10, 2)];
//		for(int i = 0; i < Math.pow(10, 2); i++) {
//			nums[i] = RandomUtils.nextInt() % 1000;
//		}
		System.out.println(minSumOfLengths(nums, target));
	}
	private static final int MAX_LEN = 9999999;
	private static final int TAIL_IDX = 0;
	private static final int LEN_IDX = 1;
	private Integer[] recursion(int curIdx, int target, int[] nums, Integer[][][] record) {
		if(target == 0) return new Integer[]{curIdx - 1, 0};
		else if(target < 0 || curIdx == nums.length) return new Integer[]{curIdx - 1, MAX_LEN};
		else if(record[curIdx][target][TAIL_IDX] != null) return record[curIdx][target].clone();

		Integer[] skip = recursion(curIdx + 1, target, nums, record);
		Integer[] include = recursion(curIdx + 1, target - nums[curIdx], nums, record);
		include[LEN_IDX] += 1;

		Integer[] min;
		if(skip[LEN_IDX] < include[LEN_IDX]) min = skip;
		else if(include[LEN_IDX] < skip[LEN_IDX]) min = include;
		else {
			if(skip[TAIL_IDX] < include[TAIL_IDX]) min = skip;
			else min = include;
		}

		record[curIdx][target] = new Integer[]{min[TAIL_IDX], min[LEN_IDX]};
		return min;
	}

	public int minSumOfLengths(int[] arr, int target) {
		Integer[][][] record = new Integer[arr.length][target + 1][2];
		Integer[] frontSub = recursion(0, target, arr, record);
		if(frontSub[LEN_IDX] >= MAX_LEN) return -1;
		Integer[] rearSub = recursion(frontSub[TAIL_IDX] + 1, target, arr, record);
		if(rearSub[LEN_IDX] >= MAX_LEN) return -1;
		return frontSub[LEN_IDX] + rearSub[LEN_IDX];
	}
}
