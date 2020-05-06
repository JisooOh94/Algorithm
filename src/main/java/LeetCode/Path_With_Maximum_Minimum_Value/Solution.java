package LeetCode.Path_With_Maximum_Minimum_Value;

import util.Predicate;


/**
 * Runtime : 2066ms(5.02%)
 * Memory : 44.9mb(100.0%)
 */
public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return maximumMinimumPath((int[][])params[0]);
	}

	public class Pos {
		public int x;
		public int y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object pos) {
			return this.x == ((Pos)pos).x && this.y == ((Pos)pos).y;
		}
	}

	int[][] delta = new int[][]{
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};

	private int totalMinScore = 0;
	private Pos dest;

	private void recursion(int[][] board, boolean[][] visited, int[][] minScoreBoard, Pos cur, int minScore) {
		if(minScore <= totalMinScore) return;

		else if(cur.equals(dest)) {
			totalMinScore = minScore;
			return;
		}

		for(int i = 0; i < 4; i++) {
			int newY = cur.y + delta[i][0];
			int newX = cur.x + delta[i][1];

			if(0 <= newY && newY < board.length && 0 <= newX && newX < board[0].length && !visited[newY][newX]) {
				int newMinScore = board[newY][newX] < minScore ? board[newY][newX] : minScore;

				if(minScoreBoard[newY][newX] < newMinScore) {
					minScoreBoard[newY][newX] = newMinScore;
					visited[newY][newX] = true;
					recursion(board, visited, minScoreBoard, new Pos(newY, newX), newMinScore);
					visited[newY][newX] = false;
				}
			}
		}
	}

	public int maximumMinimumPath(int[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return 0;
		else if(board.length == 1 && board[0].length == 1) return board[0][0];

		boolean[][] visited = new boolean[board.length][board[0].length];
		int[][] minScoreBoard = new int[board.length][board[0].length];

		dest = new Pos(board.length - 1, board[0].length - 1);
		recursion(board, visited, minScoreBoard, new Pos(0,0), board[0][0]);

		return totalMinScore;
	}
}
