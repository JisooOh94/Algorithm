package medium.Minesweeper;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 1ms(51.15%)
 * Memory : 39.4mb(56.03%)
 * Time Complexity : O(n)
 */
public class Solution {
	private static final char NOT_FOUND_MINE = 'M';
	private static final char NOT_FOUND_EMPTY = 'E';
	private static final char FOUND_MINE = 'X';
	private static final char FOUND_EMPTY = 'B';
	private static final int[][] dir = new int[][]{
			{0, -1},
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, 1},
			{1, 1},
			{1, 0},
			{1, -1}
	};

	private void recursion(int curY, int curX, char[][] board) {
		List<Integer> next = new LinkedList<>();
		int mineCnt = 0;

		for(int i = 0; i < dir.length; i++) {
			int nextY = curY + dir[i][0];
			int nextX = curX + dir[i][1];

			if(0 <= nextY && nextY < board.length && 0 <= nextX && nextX < board[0].length) {
				if (board[nextY][nextX] == NOT_FOUND_MINE) mineCnt++;
				else if (board[nextY][nextX] == NOT_FOUND_EMPTY) next.add(i);
			}
		}

		if(mineCnt > 0) board[curY][curX] = (char)(mineCnt + 48);
		else {
			board[curY][curX] = FOUND_EMPTY;
			for(int nextIdx : next) {
				int nextY = curY + dir[nextIdx][0];
				int nextX = curX + dir[nextIdx][1];

				recursion(nextY, nextX, board);
			}
		}
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		if(board[click[0]][click[1]] == NOT_FOUND_MINE) board[click[0]][click[1]] = FOUND_MINE;
		else recursion(click[0], click[1], board);
		return board;
	}
}
