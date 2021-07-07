package medium.Wiggle_Sort;

import java.util.Arrays;

public class Solution {
	public void wiggleSort(int[] nums) {
		int front = 0;
		int real = nums.length - 1;
		Arrays.sort(nums);

		int[] cpy = new int[nums.length];

		for(int i = 0; i < nums.length; ) {
			cpy[i++] = nums[front++];
			if(i < nums.length) cpy[i++] = nums[real--];
		}

		for(int i = 0; i < nums.length; i++) nums[i] = cpy[i];
	}
}
