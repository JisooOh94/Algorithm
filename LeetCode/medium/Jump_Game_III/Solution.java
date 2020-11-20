package medium.Jump_Game_III;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 47.2mb(10.47%)
 */
public class Solution {
	@Test
	public void execute() {
		int[] arr = new int[]{3,0,2,1,2};
		int startIdx = 2;

		System.out.println(canReach(arr, startIdx));
	}
	private boolean recursion(int cur, int[] arr, boolean[] visited) {
		if(cur < 0 || arr.length <= cur) return false;
		else if(arr[cur] == 0) return true;
		else if(visited[cur]) return false;

		visited[cur] = true;
		return recursion(cur - arr[cur], arr, visited) || recursion(cur + arr[cur], arr, visited);
	}

	public boolean canReach(int[] arr, int start) {
		boolean[] visited = new boolean[arr.length];
		return recursion(start, arr, visited);
	}
}
