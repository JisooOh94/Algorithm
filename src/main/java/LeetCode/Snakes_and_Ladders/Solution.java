package LeetCode.Snakes_and_Ladders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import util.Predicate;

/**
 * Runtime : 2ms(100.0%)
 * Memory : 38.8mb(94.03%)
 */
public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return snakesAndLadders((int[][])params[0]);
	}

	private static final int NORMAL = -1;

	private class Pos {
		int x;
		int y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	private Pos num2Pos(int posNum, int boardSize) {
		int newY = boardSize - 1 - posNum / boardSize;
		int newX = posNum % boardSize;

		return (boardSize % 2 == 1 && newY % 2 == 0) || (boardSize % 2 == 0 && newY % 2 == 1) ? new Pos(newY, newX) : new Pos(newY, boardSize - 1 - newX);
	}

	public int snakesAndLadders(int[][] board) {
		if(board == null || board.length == 0) return -1;
		else if(board.length == 1) return 0;

		int boardSize = board.length;
		int destNum = boardSize * boardSize - 1;
		boolean[] visited = new boolean[boardSize * boardSize];

		Queue<Integer> posQ = new LinkedList<>();
		posQ.offer(0);

		int costTime = 0;

		while(!posQ.isEmpty()) {
			int curSize = posQ.size();
			costTime++;

			for(int i = 0; i < curSize; i++) {
				int curPosNum = posQ.poll();

				for(int delta = 1; delta <= 6; delta++) {
					int targetPosNum = curPosNum + delta;
					if(targetPosNum == destNum) return costTime;

					if(destNum > targetPosNum && !visited[targetPosNum]) {
						visited[targetPosNum] = true;
						Pos targetPos = num2Pos(targetPosNum, boardSize);

						if(board[targetPos.y][targetPos.x] != NORMAL) {
							if(!visited[board[targetPos.y][targetPos.x] - 1]) {
								if (board[targetPos.y][targetPos.x] - 1 == destNum) return costTime;

								//visited[board[targetPos.y][targetPos.x] - 1] = true;
								posQ.offer(board[targetPos.y][targetPos.x] - 1);
							}
						} else {
							posQ.offer(targetPosNum);
						}
					}
				}
			}
		}

		return -1;
	}
}
