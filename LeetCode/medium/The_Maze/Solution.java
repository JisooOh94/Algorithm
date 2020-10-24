package medium.The_Maze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 14ms(12.18%)
 * Memory : 40.4mb(8.24%)
 */
public class Solution {
	private static final int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	private static final int WALL = 1;
	private static final int Y = 0;
	private static final int X = 1;
	private static final int Dir = 2;

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < 4; i++)
			if(!isWall(start[Y] + dir[i][Y], start[X] + dir[i][X], maze))
				queue.offer(new int[]{start[Y] + dir[i][Y], start[X] + dir[i][X], i});

		boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
		while(!queue.isEmpty()) {
			int[] curPos = queue.poll();
			int nextY = curPos[Y] + dir[curPos[Dir]][Y];
			int nextX = curPos[X] + dir[curPos[Dir]][X];

			if (isWall(nextY, nextX, maze)) {
				if(curPos[Y] == destination[Y] && curPos[X] == destination[X]) return true;
				for(int i = 0; i < 4; i++) {
					if(i == curPos[Dir]) continue;
					nextY = curPos[Y] + dir[i][Y];
					nextX = curPos[X] + dir[i][X];

					if(!isWall(nextY, nextX, maze) && !visited[nextY][nextX][i]) {
						visited[nextY][nextX][i] = true;
						queue.offer(new int[]{nextY, nextX, i});
					}
				}
			} else {
				if(!visited[nextY][nextX][curPos[Dir]]) {
					visited[nextY][nextX][curPos[Dir]] = true;
					queue.offer(new int[]{nextY, nextX, curPos[Dir]});
				}
			}
		}
		return false;
	}

	private boolean isWall(int y, int x, int[][] map) {
		return y < 0 || y == map.length || x < 0 || x == map[0].length || map[y][x] == WALL;
	}
}
