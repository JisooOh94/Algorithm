package easy.Find_the_Town_Judge;

import org.junit.Test;

/**
 * Runtime : 13mw(22.10%)
 * Memory : 91.4mb(5.06%)
 */
public class Answer {
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
		int[] believed = new int[N + 1];

		for(int[] trust : trustArr) {
			believed[trust[BELIEVE]]--;
			believed[trust[BELIEVED]]++;
		}

		for(int i = 1; i <= N; i++) {
			if(believed[i] == N - 1) return i;
		}
		return -1;
	}
}
