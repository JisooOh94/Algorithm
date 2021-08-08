package medium.Maximum_Number_of_Consecutive_Values_You_Can_Make;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 15ms(96.35%)
 * Memory : 46.8mb(40.88%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

		Iterator<Integer> iterator = list.iterator();
		for(int i = 0; i < 3; i++) {
			list.add(iterator.next() + 10);
		}
	}
	public int getMaximumConsecutive(int[] coins) {
		Arrays.sort(coins);
		int max = 0;
		for(int cur : coins) {
			if(max + 1 < cur) break;
			else max = max + cur;
		}
		return max + 1;
	}
}
