package medium.Last_Stone_Weight_II;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] stones = new int[]{2,7,4,1,8,1};
//		int[] stones = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 14, 23, 37, 61, 98};
		System.out.println(lastStoneWeightII(stones));
	}

	private int recursion(int curIdx, int nextSearchIdx, int[] stones) {
		int minLeftStonSize = stones[curIdx];
		for(int i = nextSearchIdx; i < stones.length; i++) {
			if(stones[curIdx] <= stones[i]) {
				int backup = stones[curIdx];
				stones[i] -= stones[curIdx];
				stones[curIdx] = 0;

				for(int j = curIdx + 1; j < stones.length; j++) {
					if(stones[j] != 0) {
						minLeftStonSize = Math.min(minLeftStonSize,recursion(j, j + 1, stones));
						break;
					}
				}

				stones[i] += backup;
				stones[curIdx] = backup;
			} else if(stones[i] != 0){
				int backup = stones[i];
				stones[curIdx] -= stones[i];
				stones[i] = 0;

				minLeftStonSize = Math.min(minLeftStonSize, recursion(curIdx, i + 1, stones));

				stones[curIdx] += backup;
				stones[i] = backup;
			}
		}

		return minLeftStonSize;
	}

	public int lastStoneWeightII(int[] stones) {
		Arrays.sort(stones);
		return recursion(0, 1, stones);
	}
}
