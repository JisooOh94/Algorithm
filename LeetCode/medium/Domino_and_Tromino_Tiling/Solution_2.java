package medium.Domino_and_Tromino_Tiling;

import org.junit.Test;

/**
 * Runtime : 4ms(10.51%)
 * Memory : 48.4mb(5.09%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int n = 29;
		System.out.println(numTilings(n));
	}

	private static final long MOD = (long)Math.pow(10, 9) + 7;

	private Long recursion(int idx_1, int idx_2, int size, Long[][] record) {
		if(idx_1 == size || idx_2 == size) return idx_1 == idx_2 ? 1L : 0L;
		else if(record[idx_1][idx_2] != null) return record[idx_1][idx_2];

		long cnt = 0L;
		if(idx_1 == idx_2 && idx_1 + 1 <= size) {
			if(idx_1 + 2 <= size) {
				cnt += recursion(idx_1 + 2, idx_2 + 2, size, record);
				cnt += recursion(idx_1 + 2, idx_2 + 1, size, record);
				cnt += recursion(idx_1 + 1, idx_2 + 2, size, record);
			}
			cnt += recursion(idx_1 + 1, idx_2 + 1, size, record);
		} else if(idx_1 - idx_2 == 1 && idx_1 + 1 <= size) {
			cnt += recursion(idx_1, idx_2 + 2, size, record);
			cnt += recursion(idx_1 + 1, idx_2 + 2, size, record);
		} else if(idx_2 - idx_1 == 1 && idx_2 + 1 <= size) {
			cnt += recursion(idx_1 + 2, idx_2, size, record);
			cnt += recursion(idx_1 + 2, idx_2 + 1, size, record);
		}

		cnt = cnt % MOD;
		record[idx_1][idx_2] = cnt;
		return cnt;
	}

	public int numTilings(int N) {
		Long[][] record = new Long[N][N];
		return recursion(0, 0, N, record).intValue();
	}
}
