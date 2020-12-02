package medium.Product_of_the_Last_K_Numbers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 16ms(45.84%)
 * Memory : 63.4mb(24.65%)
 */
public class Solution {
	class ProductOfNumbers {
		List<int[]> cache = new LinkedList<>();
		public ProductOfNumbers() {
		}

		public void add(int num) {
			if(num == 0) cache.clear();
			else {
				if(num != 1) {
					for (Iterator<int[]> iter = cache.iterator(); iter.hasNext(); ) {
						int[] val = iter.next();
						val[0] *= num;
					}
				}
				cache.add(new int[]{num});
			}
		}

		public int getProduct(int k) {
			if(cache.size() < k) return 0;
			return cache.get(cache.size() - k)[0];
		}
	}
}
