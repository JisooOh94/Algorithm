package pack;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Prob_3 {
	@Test
	public void execute() {
		int[][] board = new int[][]{
				{2, 4, 8, 2}, {2, 2, 2, 2}, {0, 4, 2, 4}, {2, 2, 2, 4}
		};

		System.out.println(solution(board));
	}

	int[][] dir = new int[][]{
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	int[][] startPos = new int[][]{
			{3, 0},
			{0, 0},
			{0, 3},
			{0, 0},
	};

	int[][] dirModif = new int[][]{
			{0, 1},
			{1, 0}
	};

	private int merge(int dirIdx, int startY, int startX, int[][] map) {
		int maxNum = 0;
		Integer sourceNum = null;
		List<Integer> resultNum = new LinkedList<>();
		int y = startY, x = startX;
		for (int i = 0; i < 4; i++) {
			if (map[y][x] != 0) {
				if (sourceNum == null) {
					sourceNum = map[y][x];
				} else {
					int targetNum = map[y][x];
					if (sourceNum == targetNum) {
						resultNum.add(sourceNum * 2);
						sourceNum = null;
					} else {
						resultNum.add(sourceNum);
						sourceNum = targetNum;
					}
				}
			}
			y += dir[dirIdx][0] * -1;
			x += dir[dirIdx][1] * -1;
		}
		if(sourceNum != null) resultNum.add(sourceNum);

		for(int num : resultNum) {
			if(num > maxNum) maxNum = num;
			map[startY][startX] = num;
			startY += dir[dirIdx][0] * -1;
			startX += dir[dirIdx][1] * -1;
		}

		for(int i = resultNum.size(); i < 4; i++) {
			map[startY][startX] = 0;
			startY += dir[dirIdx][0] * -1;
			startX += dir[dirIdx][1] * -1;
		}
		return maxNum;
	}

	private int[][] mapCopy(int[][] source) {
		int[][] copy = new int[4][4];
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 4; x++) {
				copy[y][x] = source[y][x];
			}
		}
		return copy;
	}

	private int recursion(int cnt, int[][] map) {
		if(cnt == 5) return 0;

		int max = 0;
		for(int dir = 0; dir < 4; dir++) {
			int curMax = 0;
			int[][] mapCopy = mapCopy(map);
			int y = startPos[dir][0];
			int x = startPos[dir][1];

			for (int i = 0; i < 4; i++){
				curMax = Math.max(curMax,merge(dir, y, x, mapCopy));
				y += dirModif[dir / 2][0];
				x += dirModif[dir / 2][1];
			}

			curMax = Math.max(curMax,recursion(cnt + 1, mapCopy));
			max = Math.max(max, curMax);
		}
		return max;
	}

	int solution(int[][] board) {
		return recursion(0, board);
	}
}
