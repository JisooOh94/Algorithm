package medium.Shortest_Bridge;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 10ms(40.28%)
 * Memory : 39.2mb(98.61%)
 */
public class Solution {
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

	public int shortestBridge(int[][] map) {
		int[] start = null;
		boolean[][] visited = new boolean[map.length][map[0].length];

		for(int y = 0; y < map.length; y++) {
			if(start != null) break;
			for(int x = 0; x < map[0].length; x++) {
				if(map[y][x] == 1) {
					start = new int[]{y, x};
					visited[y][x] = true;
					break;
				}
			}
		}

		LinkedList<int[]> group = new LinkedList<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		group.offer(start);
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int neighborY = cur[0] + move[i][0];
				int neighborX = cur[1] + move[i][1];

				if(0 <= neighborY && neighborY < map.length && 0 <= neighborX && neighborX < map[0].length && map[neighborY][neighborX] == 1 && !visited[neighborY][neighborX]) {
					int[] neighbor = new int[]{neighborY, neighborX};
					queue.offer(neighbor);
					group.offer(neighbor);
					visited[neighborY][neighborX] = true;
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
