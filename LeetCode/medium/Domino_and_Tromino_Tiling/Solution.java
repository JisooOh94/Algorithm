package medium.Domino_and_Tromino_Tiling;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int n = 29;
		System.out.println(numTilings(n));
	}

	private static final long MOD = (long)Math.pow(10, 9) + 7;

	private Long recursion(int idx_1, int idx_2, int size, Long[][] record) {
		if(idx_1 == size || idx_2 == size) return idx_1 == idx_2 ? 1L : 0L;
		else if(record[idx_1][idx_2] != null) return record[idx_1][idx_2];

		long cnt = 0;
		if(idx_1 + 2 <= size) {
			if(idx_1 == idx_2) cnt += recursion(idx_1 + 2, idx_2 + 2, size, record);
			else if(idx_2 - idx_1 == 1) cnt += recursion(idx_1 + 2, idx_2, size, record);
		}

		if(idx_2 + 2 <= size && idx_1 - idx_2 == 1) cnt += recursion(idx_1, idx_2 + 2, size, record);

		if(idx_1 == idx_2 && idx_1 < size) cnt += recursion(idx_1 + 1, idx_2 + 1, size, record) + recursion(idx_1 + 2, idx_2 + 1, size, record) + recursion(idx_1 + 1, idx_2 + 2, size, record);

		if(Math.abs(idx_1 - idx_2) == 1 && Math.max(idx_1, idx_2) < size) cnt += idx_1 > idx_2 ? recursion(idx_1 + 1, idx_2 + 2, size, record) : recursion(idx_1 + 2, idx_2 + 1, size, record);

		cnt %= MOD;
		record[idx_1][idx_2] = cnt;
		return cnt;
	}

	public int numTilings(int N) {
		Long[][] record = new Long[N][N];
		return recursion(0, 0, N, record).intValue();
	}
}
