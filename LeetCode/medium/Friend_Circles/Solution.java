package medium.Friend_Circles;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.9mb(14.65%)
 */
public class Solution {
	private void recursion (int cur, int[][] map, boolean[] visited) {
		visited[cur] = true;

		for(int i = 0; i < map.length; i++) {
			if(cur == i) continue;
			if(map[cur][i] == 1 && !visited[i]) {
				recursion(i, map, visited);
			}
		}
	}
	public int findCircleNum(int[][] M) {
		if(M.length == 1) return 1;
		boolean[] visited = new boolean[M.length];
		int circleCnt = 0;
		for(int i = 0; i < M.length; i++) {
			if(!visited[i]) {
				circleCnt++;
				recursion(i, M, visited);
			}
		}
		return circleCnt;
	}
}
