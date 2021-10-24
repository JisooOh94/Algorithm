package medium.Minimum_Factorization;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 4ma(5.00%)
 * Memory : 37.6mb(60.00%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int num = 15;
		System.out.println(smallestFactorization(num));
	}
	public int smallestFactorization(int num) {
		List<Integer> primeFactors = new LinkedList<>();
		for(int i = 2; i < num; i++) {
			if(9 < i) return 0;
			while(num % i == 0) {
				primeFactors.add(i);
				num /= i;
			}
		}
		if(num != 1) primeFactors.add(num);

		List<Integer> numsAscending = new LinkedList<>();
		List<Integer> numsDescending = new LinkedList<>();
		int ascendingMult = 1;
		int descendingMult = 1;

		Iterator<Integer> ascendingIter = primeFactors.iterator();
		Iterator<Integer> descendingIter = ((LinkedList<Integer>) primeFactors).descendingIterator();
		while(ascendingIter.hasNext() && descendingIter.hasNext()) {
			int cur = ascendingIter.next();
			if(ascendingMult * cur > 9) {
				numsAscending.add(ascendingMult);
				ascendingMult = cur;
			} else {
				ascendingMult *= cur;
			}

			cur = descendingIter.next();
			if(descendingMult * cur > 9) {
				numsDescending.add(descendingMult);
				descendingMult = cur;
			} else {
				descendingMult *= cur;
			}
		}
		numsAscending.add(ascendingMult);
		numsDescending.add(descendingMult);

		long resultAscending = 0;
		long resultDescending = 0;
		Collections.sort(numsAscending, Collections.reverseOrder());
		Collections.sort(numsDescending, Collections.reverseOrder());
		for(int i = 0; i < numsAscending.size(); i++) resultAscending += numsAscending.get(i) * Math.pow(10, i);
		for(int i = 0; i < numsDescending.size(); i++) resultDescending += numsDescending.get(i) * Math.pow(10, i);
		return resultAscending > Integer.MAX_VALUE && resultDescending > Integer.MAX_VALUE ? 0 : (int)Math.min(resultAscending, resultDescending);
	}
}
