package Word_Search;

import util.Predicate;

public class Solution implements Predicate<Boolean, Object> {
	public Boolean test(Object... params) {
		return exist((char[][])params[0], (String)params[1]);
	}

	private int[][] yx = new int[][] {
			{-1,0},		//up
			{1,0},		//down
			{0,-1},		//left
			{0,1}		//right
	};

	public class Pos {
		public int x;
		public int y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	private boolean recursion (char[][] board, boolean[][] visited, String word, int wordIdx, Pos cur) {
		if(wordIdx == word.length()) {
			return true;
		}

		for(int i = 0; i < 4; i++) {
			int newY = cur.y + yx[i][0];
			int newX = cur.x + yx[i][1];

			if(0 <= newY && newY < board.length && 0 <= newX && newX < board[0].length && !visited[newY][newX] && board[newY][newX] == word.charAt(wordIdx)) {
				visited[newY][newX] = true;
				if(recursion(board, visited, word, wordIdx + 1, new Pos(newY, newX))) {
					return true;
				}
				visited[newY][newX] = false;
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word) {
		if(board == null || word == null) return false;
		else if(board.length == 0 || board[0].length == 0 || word.length() == 0) return false;
		else if(board.length * board[0].length < word.length()) return false;

		boolean[][] visited = new boolean[board.length][board[0].length];

		for(int y = 0; y < board.length; y++) {
			for(int x = 0; x < board[0].length; x++) {
				if(board[y][x] == word.charAt(0)) {
					visited[y][x] = true;
					if(recursion(board, visited, word, 1, new Pos(y,x))) {
						return true;
					}
					visited[y][x] = false;
				}
			}
		}

		return false;
	}
}
