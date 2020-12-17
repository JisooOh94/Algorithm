package medium.Shortest_Bridge;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 10ms(40.28%)
 * Memory : 39.2mb(98.61%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[][] map = new int[][]{
				{1,0},
				{0,1}
		};

		System.out.println(shortestBridge(map));
	}
	int[][] move = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	private void recursion(int[] cur, int[][] map, boolean[][] visited, LinkedList<int[]> group) {
		group.offer(cur);
		for(int i = 0; i < 4; i++) {
			int neighborY = cur[0] + move[i][0];
			int neighborX = cur[1] + move[i][1];

			if(0 <= neighborY && neighborY < map.length && 0 <= neighborX && neighborX < map[0].length && map[neighborY][neighborX] == 1 && !visited[neighborY][neighborX]) {
				visited[neighborY][neighborX] = true;
				recursion(new int[]{neighborY, neighborX}, map, visited, group);
			}
		}
	}

	public int shortestBridge(int[][] map) {
		boolean[][] visited = new boolean[map.length][map[0].length];
		LinkedList<int[]> group = new LinkedList<>();

		for(int y = 0; y < map.length; y++) {
			if(group.size() != 0) break;
			for(int x = 0; x < map[0].length; x++) {
				if(map[y][x] == 1) {
					visited[y][x] = true;
					recursion(new int[]{y, x}, map, visited, group);
					break;
				}
			}
		}

		int stepCnt = 0;
		while(!group.isEmpty()) {
			int size = group.size();
			while(size-- > 0) {
				int[] cur = group.poll();
				for(int i = 0; i < 4; i++) {
					int neighborY = cur[0] + move[i][0];
					int neighborX = cur[1] + move[i][1];

					if(0 <= neighborY && neighborY < map.length && 0 <= neighborX && neighborX < map[0].length) {
						if(map[neighborY][neighborX] == 1 && !visited[neighborY][neighborX]) {
							return stepCnt;
						} else if(map[neighborY][neighborX] == 0 && !visited[neighborY][neighborX]) {
							group.offer(new int[]{neighborY, neighborX});
							visited[neighborY][neighborX] = true;
						}
					}
				}
			}
			stepCnt++;
		}
		return -1;
	}
}
