package easy.Find_the_Town_Judge;

import org.junit.Test;

/**
 * Runtime : 13mw(22.10%)
 * Memory : 91.4mb(5.06%)
 */
public class Solution {
	@Test
	public void execute() {
		int N = 2;
		int[][] trust = new int[][]{
				{1,2}
		};
		System.out.println(findJudge(N, trust));
	}
	private static final int BELIEVE = 0;
	private static final int BELIEVED = 1;
	public int findJudge(int N, int[][] trustArr) {
		boolean[][] believed = new boolean[N][N];
		boolean[] believing = new boolean[N];

		for(int[] trust : trustArr) {
			believing[trust[BELIEVE] - 1] = true;
			believed[trust[BELIEVED] - 1][trust[BELIEVE] - 1] = true;
		}

		for(int i = 0; i < N; i++) {
			if(!believing[i]) {
				boolean result = true;
				for(int j = 0; j < N; j++) {
					if(j != i && believed[i][j] == false) {
						result = false;
						break;
					}
				}

				if(result) return i + 1;
			}
		}
		return -1;
	}
}
