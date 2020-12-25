package pack;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Prob_3_2 {
	@Test
	public void execute() {
		int[][] board = new int[][]{
				{2, 4, 8, 2}, {2, 2, 2, 2}, {0, 4, 2, 4}, {2, 2, 2, 4}
		};

		System.out.println(solution(board));
	}

	private static final int EMPTY = 0;
	private static final int Y = 0;
	private static final int X = 1;

	int[][] modifyingByDir = new int[][]{
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};

	int[][] mergeStartPosByDir = new int[][]{
			{3, 0},
			{0, 0},
			{0, 3},
			{0, 0},
	};

	private int merge(int dirIdx, int mergeStartY, int mergeStartX, int[][] map) {
		List<Integer> mergedNumList = new LinkedList<>();
		Integer mergeCandidateNum = null;
		int curY = mergeStartY, curX = mergeStartX;

		for (int i = 0; i < map.length; i++) {
			if (map[curY][curX] != EMPTY) {
				if (mergeCandidateNum == null) {
					mergeCandidateNum = map[curY][curX];
				} else if (mergeCandidateNum == map[curY][curX]) {
					mergedNumList.add(mergeCandidateNum * 2);
					mergeCandidateNum = null;
				} else {
					mergedNumList.add(mergeCandidateNum);
					mergeCandidateNum = map[curY][curX];
				}
			}
			curY += modifyingByDir[dirIdx][Y];
			curX += modifyingByDir[dirIdx][X];
		}
		if(mergeCandidateNum != null) mergedNumList.add(mergeCandidateNum);

		return applyMergeToMap(mergedNumList, map, mergeStartY, mergeStartX, dirIdx);
	}

	private int applyMergeToMap(List<Integer> mergedNumList, int[][] map, int yPos, int xPos, int dirIdx) {
		int maxMergedNum = 0;
		for(int mergedNum : mergedNumList) {
			if(mergedNum > maxMergedNum) maxMergedNum = mergedNum;
			map[yPos][xPos] = mergedNum;
			yPos += modifyingByDir[dirIdx][Y];
			xPos += modifyingByDir[dirIdx][X];
		}

		for(int i = mergedNumList.size(); i < map.length; i++) {
			map[yPos][xPos] = EMPTY;
			yPos += modifyingByDir[dirIdx][Y];
			xPos += modifyingByDir[dirIdx][X];
		}
		return maxMergedNum;
	}

	private int[][] mapCopy(int[][] source) {
		int[][] copy = new int[source.length][source[0].length];
		for(int y = 0; y < source.length; y++) {
			for(int x = 0; x < source[0].length; x++) {
				copy[y][x] = source[y][x];
			}
		}
		return copy;
	}

	private int recursion(int cnt, int[][] map) {
		if(cnt == 5) return 0;

		int max = 0;
		for(int dirIdx = 0; dirIdx < 4; dirIdx++) {
			int curMax = 0;
			int[][] mapCopy = mapCopy(map);
			int y = mergeStartPosByDir[dirIdx][Y];
			int x = mergeStartPosByDir[dirIdx][X];

			for (int i = 0; i < map.length; i++){
				curMax = Math.max(curMax,merge(dirIdx, y, x, mapCopy));
				y += dirIdx < 2 ? 0 : 1;
				x += dirIdx < 2 ? 1 : 0;
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
