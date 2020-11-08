package medium.Sort_Integers_by_The_Power_Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Runtime : 43ms(90.78%)
 * Memory : 38.6mb(6.03%)
 */
public class Solution {
	@Test
	public void execute() {
		int lo = 12;
		int hi = 15;
		int k = 2;
		System.out.println(getKth(lo, hi, k));
	}
	private int recursion(int cur, Map<Integer, Integer> record) {
		if(cur == 1) return 0;
		else if(record.containsKey(cur)) return record.get(cur);

		int curPower = 1 + (cur % 2 == 0 ? recursion(cur / 2, record) : recursion(cur * 3 + 1, record));
		record.put(cur, curPower);
		return curPower;
	}
	public int getKth(int lo, int hi, int k) {
		Map<Integer, Integer> record = new HashMap<>();

		int[][] result = new int[hi - lo][2];

		for(int num = lo; num <= hi; num++) {
			int power = recursion(num, record);
			result[num - lo][0] = num;
			result[num - lo][1] = power;
		}

		Arrays.sort(result, (e1, e2) -> e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : 0);

		return result[k - 1][0];
	}
}