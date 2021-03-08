package 스티커_모으기_2;

import org.junit.Test;

public class Solution_3 {
	@Test
	public void execute() {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		System.out.println(solution(arr));
	}
	private int recursion(int cur, int[] arr, int maxIdx, Integer[] record) {
		if(cur == maxIdx) return 0;
		else if(cur == maxIdx - 1) return arr[cur];
		else if(record[cur] != null) return record[cur];

		int maxSum = Math.max(arr[cur] + recursion(cur + 2, arr, maxIdx, record), recursion(cur + 1, arr, maxIdx, record));
		record[cur] = maxSum;
		return maxSum;
	}
	public int solution(int sticker[]) {
		if(sticker.length == 1) return sticker[0];
		Integer[] record = new Integer[sticker.length];

		int profit_1 = sticker[0] - (sticker[1] + sticker[sticker.length - 1]);
		int profit_2 = sticker[sticker.length - 1] - (sticker[0] + sticker[sticker.length - 2]);
		return profit_1 > profit_2 ? sticker[0] + recursion(2, sticker, sticker.length - 1, record) : sticker[1] + recursion(3, sticker, sticker.length, record);
	}
}
