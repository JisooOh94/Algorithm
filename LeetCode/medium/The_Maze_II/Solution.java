package medium.The_Maze_II;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 13ms(27.38%)
 * Memory : 40.1mb(21.62%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] maze = new int[][]{
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};
		int[] start = new int[]{0, 4};
		int[] end = new int[]{1, 4};
		System.out.println(shortestDistance(maze, start, end));
	}
	private int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		if(start[0] == destination[0] && start[1] == destination[1]) return 0;
		int height = maze.length;
		int width = maze[0].length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[height][width][4];
		for(int i = 0; i < 4; i++) {
			queue.offer(new int[]{start[0], start[1], i});
		}

		int stepCnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int elemIdx = 0; elemIdx < size; elemIdx++) {
				int[] cur = queue.poll();
				int nextY = cur[0] + dir[cur[2]][0];
				int nextX = cur[1] + dir[cur[2]][1];
				if(nextY < 0 || height <= nextY || nextX < 0 || width <= nextX || maze[nextY][nextX] == 1) {
					if(cur[0] == destination[0] && cur[1] == destination[1]) return stepCnt;
					for(int i = 0; i < 4; i++) {
						if(i == cur[2]) continue;
						int turnedY = cur[0] + dir[i][0];
						int turnedX = cur[1] + dir[i][1];

						if(0 <= turnedY && turnedY < height && 0 <= turnedX && turnedX < width && maze[turnedY][turnedX] != 1 && !visited[turnedY][turnedX][i]) {
							queue.offer(new int[]{turnedY, turnedX, i});
							visited[cur[0]][cur[1]][i] = visited[turnedY][turnedX][i] = true;
						}
					}
				} else if (!visited[nextY][nextX][cur[2]]){
					queue.offer(new int[]{nextY, nextX, cur[2]});
					visited[cur[0]][cur[1]][cur[2]] = true;
				}
			}
			stepCnt++;
		}
		return -1;
	}
}
