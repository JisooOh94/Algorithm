package medium.Minimum_Sideway_Jumps;

import org.junit.Test;

/**
 * Runtime : 9ms(99.29%)
 * Memory : 108.3mb(62.06%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
		int[] obstacles = new int[]{0,1,2,3,0};

		System.out.println(minSideJumps(obstacles));
	}

	public int minSideJumps(int[] obstacles) {
		int curPos = 2;
		boolean sideJumped = false;
		int sideJumpCnt = 0;

		for(int i = 0; i < obstacles.length - 1; i++) {
			if(!sideJumped && obstacles[i + 1] == curPos) {
				if(obstacles[i] != 0) {
					curPos = curPos == 1 ? obstacles[i] == 2 ? 3 : 2 : curPos == 2 ? obstacles[i] == 1 ? 3 : 1 : curPos == 3 ? obstacles[i] == 1 ? 2 : 1 : 0;
				} else {
					sideJumped = true;
				}
				sideJumpCnt++;
			} else if(sideJumped && obstacles[i + 1] != 0 && obstacles[i + 1] != curPos) {
				sideJumped = false;
				curPos = curPos == 1 ? obstacles[i + 1] == 2 ? 3 : 2 : curPos == 2 ? obstacles[i + 1] == 1 ? 3 : 1 : curPos == 3 ? obstacles[i + 1] == 1 ? 2 : 1 : 0;
			}
		}

		return sideJumpCnt;
	}
}
