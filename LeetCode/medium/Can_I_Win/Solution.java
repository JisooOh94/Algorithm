package medium.Can_I_Win;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int max = 10;
		int target = 14;
		System.out.println(canIWin(max, target));
	}
	private boolean recursion(int fr, int re, boolean isPlayer, int target, Boolean[][] record) {
		if(target <= 0) return !isPlayer;
		else if(record[fr][re] != null) return record[fr][re];

		boolean frResult = recursion(fr + 1, re, !isPlayer, target - fr, record);
		boolean reResult = recursion(fr, re - 1, !isPlayer, target - re, record);

		boolean isWinnable = isPlayer ? frResult || reResult : frResult && reResult;
		record[fr][re] = isWinnable;
		return isWinnable;
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if(desiredTotal < 2) return true;
		else if((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
		Boolean[][] record = new Boolean[maxChoosableInteger + 1][maxChoosableInteger + 1];
		return recursion(2, maxChoosableInteger, false, desiredTotal - 1, record) || recursion(1, maxChoosableInteger - 1, false, desiredTotal - maxChoosableInteger, record);
	}
}
