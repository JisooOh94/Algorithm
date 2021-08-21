package medium.Distant_Barcodes;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 48ms(23.12%)
 * Memory : 75.7mb(11.02%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		int[] barcodes = new int[]{7,7,7,8,5,7,5,5,5,8};
		int[] barcodes = new int[]{1,1,2};

		Arrays.stream(rearrangeBarcodes(barcodes)).forEach(System.out::print);
	}
	private static final int KEY = 0;
	private static final int VAL = 1;
	public int[] rearrangeBarcodes(int[] barcodes) {
		if(barcodes.length == 1) return barcodes;
		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[VAL] > e2[VAL] ? -1 : e1[VAL] < e2[VAL] ? 1 : 0);
		Arrays.sort(barcodes);

		int cur = barcodes[0];
		int cnt = 1;
		for(int i = 1; i < barcodes.length; i++) {
			if(cur != barcodes[i]) {
				queue.offer(new int[]{cur, cnt});
				cur = barcodes[i];
				cnt = 0;
			}
			cnt++;
		}
		queue.offer(new int[]{cur, cnt});

		int[] cpy = new int[barcodes.length];
		int idx = 0;
		while(idx < barcodes.length) {
			int[] a = queue.poll();
			int[] b = queue.poll();
			cpy[idx++] = a[KEY];
			a[VAL]--;
			if(a[VAL] != 0) queue.offer(a);
			if(b != null) {
				cpy[idx++] = b[KEY];
				b[VAL]--;
				if(b[VAL] != 0) queue.offer(b);
			}
		}

		return cpy;
	}
}
