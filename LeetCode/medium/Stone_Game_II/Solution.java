package medium.Stone_Game_II;

import org.junit.Test;

/**
 * Runtime : 10ms(15.58%)
 * Memory : 44.9mb(5.26%)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] piles = new int[]{2,7,9,4,4};
//		int[] piles = new int[]{1,2,3,4,5,100};
//		int[] piles = new int[]{8270,7145,575,5156,5126,2905,8793,7817,5532,5726,7071,7730,5200,5369,5763,7148,8287,9449,7567,4850,1385,2135,1737,9511,8065,7063,8023,7729,7084,8407};
		int[] piles = new int[]{9,2,2,8,3,7, 7, 7};
		//int[] piles = new int[]{1,2,3,4,5,6,7, 8};
		System.out.println(stoneGameII(piles));
	}

	private static final int[] emptyArr = new int[]{0,0};

	private int[] findBest(int turn, int[] nrr, int startIdx, int range, int[][][][] record) {
		if(startIdx == (nrr.length -1)) return turn == 0 ? new int[]{nrr[startIdx], 0} : new int[]{0, nrr[startIdx]};
		else if(startIdx >= nrr.length) return new int[2];
		else if(record[startIdx][turn][turn][range] != 0) {
			return new int[]{record[startIdx][turn][0][range],record[startIdx][turn][1][range]};
		}

		int[] maxScore = emptyArr;
		int sum = 0;
		for(int i = startIdx; i < Math.min(startIdx + range * 2, nrr.length); i++) {
			sum += nrr[i];
			int[] curScore = findBest((turn + 1) % 2, nrr, i + 1, Math.max(range, i + 1 - startIdx), record);
			curScore[turn] += sum;
			if(curScore[turn] > maxScore[turn]) maxScore = curScore;
		}

		record[startIdx][turn][0][range] = maxScore[0];
		record[startIdx][turn][1][range] = maxScore[1];
		return maxScore;
	}

	public int stoneGameII(int[] piles) {
		int[][][][] record = new int[piles.length][2][2][100];
		int[] result = findBest(0, piles, 0, 1, record);
		return result[0];
	}
}
