package medium.Surrounded_Regions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 3ms(29.96%)
 * Memory : 41.1mb(60.23%)
 */
public class Solution {
	@Test
	public void execute() {
		char[][] board = new char[][]{
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}
		};

		solve(board);
	}
	private static final int[][] neighborRange = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	private static final int[][] move = new int[][]{
			{0, 1},
			{1, 0}
	};

	boolean inRange(int y, int x, int height, int width) {
		return 0 <= y && y < height && 0 <= x && x < width;
	}

	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return;
		int height = board.length;
		int width = board[0].length;
		int[][] startPos = new int[][]{
				{0,0},
				{height - 1, 0},
				{1, 0},
				{1, width - 1}
		};

		boolean[][] visited  = new boolean[height][width];

		List<int[]> markList = new LinkedList<>();

		for(int idx = 0; idx < 4; idx++) {
			int y = startPos[idx][0];
			int x = startPos[idx][1];

			while(y < height && x < width) {
				if(board[y][x] == 'O' && !visited[y][x]) {
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[]{y, x});
					visited[y][x] = true;

					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						markList.add(cur);

						for(int j = 0; j < 4; j++) {
							int neighborY = cur[0] + neighborRange[j][0];
							int neighborX = cur[1] + neighborRange[j][1];

							if(inRange(neighborY, neighborX, height, width) && !visited[neighborY][neighborX] && board[neighborY][neighborX] == 'O') {
								visited[neighborY][neighborX] = true;
								queue.offer(new int[]{neighborY, neighborX});
							}
						}
					}
				}
				y += move[idx / 2][0];
				x += move[idx / 2][1];
			}
		}

		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				board[y][x] ='X';
			}
		}

		for(int[] mark : markList) {
			board[mark[0]][mark[1]] = 'O';
		}
	}
}
