package medium.Can_I_Win;

import org.junit.Test;

public class Solution_2 {
	@Test
	public void execute() {
//		int max = 7; int target = 16;
//		int max = 10; int target = 14;
//		int max = 10; int target = 40;
//		int max = 20; int target = 210;
		int max = 7; int target = 21;
		System.out.println(canIWin(max, target));
	}
	private boolean recursion(int min, int max, boolean isPlayer, int target, boolean[] used, Boolean[][][][] record) {
		if(target <= max) return isPlayer;
		else if(record[min][max][target][isPlayer ? 0 : 1] != null) return record[min][max][target][isPlayer ? 0 : 1];
		Boolean winnable = null;

		int idx = min;
		do {
			if(!used[idx]) {
				used[idx] = true;
				int nextMin = min;
				int nextMax = max;
				if(idx == min) {
					while(used[nextMin]) nextMin++;
				}
				if(idx == max) {
					while(used[nextMax]) nextMax--;
				}

				boolean result = recursion(nextMin, nextMax, !isPlayer, target - idx, used, record);
				used[idx] = false;
				winnable = winnable == null ? result : isPlayer ? winnable || result : winnable && result;
				if(winnable && isPlayer) break;
			}
			idx++;
		} while(idx < target - max && idx <= max);

		record[min][max][target][isPlayer ? 0 : 1] = winnable;
		return winnable;
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if(desiredTotal < 2) return true;
		else if((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
		boolean[] used = new boolean[maxChoosableInteger + 1];
		Boolean[][][][] record = new Boolean[maxChoosableInteger + 1][maxChoosableInteger + 1][desiredTotal + 1][2];

		return recursion(1, maxChoosableInteger, true, desiredTotal, used, record);
	}
}
