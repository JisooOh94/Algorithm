package 스티커_모으기_2;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		System.out.println(solution(arr));
	}
	private static final int ABLE = 0;
	private static final int UNABLE = 1;
	private int recursion(int cur, int[] arr, int lastAble, Integer[][] record) {
		if(cur >= arr.length) return 0;
		else if(cur == arr.length - 1) return lastAble == ABLE ? arr[cur] : 0;
		else if(record[cur][lastAble] != null) return record[cur][lastAble];

		int maxSum = Math.max(arr[cur] + recursion(cur + 2, arr, lastAble, record), arr[cur  + 1] + recursion(cur + 3, arr, lastAble, record));
		record[cur][lastAble] = maxSum;
		return maxSum;
	}
	public int solution(int sticker[]) {
		if(sticker.length == 1) return sticker[0];
		Integer[][] record = new Integer[sticker.length][2];
		return Math.max(recursion(0, sticker, UNABLE, record), recursion(1, sticker, ABLE, record));
	}
}
