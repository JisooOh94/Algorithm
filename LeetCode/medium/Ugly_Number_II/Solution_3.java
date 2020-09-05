package medium.Ugly_Number_II;

import java.util.TreeSet;

import org.junit.Test;

/**
 * Runtime : 56ms(28.52%)
 * Memory : 39.5mb(32.63%)
 */
public class Solution_3 {
	@Test
	public void execute() {
		int n = 1407;
		System.out.println(nthUglyNumber(n));
	}

	public int nthUglyNumber(int n) {
		TreeSet<Long> set = new TreeSet<>() ;
		set.add(1L);
		int cnt = 1;

		while(cnt++ < n) {
			long val = set.first();
			set.pollFirst();

			set.add(val * 2L);
			set.add(val * 3L);
			set.add(val * 5L);
		}
		return set.pollFirst().intValue();
	}
}
