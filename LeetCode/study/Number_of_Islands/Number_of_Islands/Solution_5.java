package study.Number_of_Islands.Number_of_Islands;

import java.util.LinkedList;
import java.util.Queue;
import util.Predicate;

/**
 * Runtime : 6 ms(24.56%)
 * Memory : 48.71MB(91.83%)
 */
public class Solution_5 implements Predicate<Integer, Object> {
	@Override
	public Integer test(Object... params) {
		return numIslands((char[][])params[0]);
	}

	private int[][] neighbor = new int[][] {
			{1, 0},		//down
			{-1, 0},	//up
			{0, 1},		//right
			{0, -1}		//left
	};

	private int[] parent;
	private int islandCnt = 0;

	private int find(int idx) {
		if (idx == parent[idx]) return idx;
		parent[idx] = find(parent[idx]);
		return parent[idx];
	}

	private void union(int x, int y) {
		int xParent = find(x);
		int yParent = find(y);

		if(xParent != yParent) {
			parent[yParent] = xParent;
			islandCnt--;
		}
	}

	public int numIslands(char[][] grid) {
		int height = grid.length;
		if (height == 0) return 0;

		int width = grid[0].length;
		if (width == 0) return 0;

		parent = new int[height * width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (grid[y][x] == '1') {
					parent[y * width + x] = y * width + x;
					islandCnt++;
				}
			}
		}

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (grid[y][x] == '1') {
					grid[y][x] = '0';
					for (int i = 0; i < neighbor.length; i++) {
						int neighborY = y + neighbor[i][0];
						int neighborX = x + neighbor[i][1];
						if (neighborY < height && 0 <= neighborY && neighborX < width && 0 <= neighborX && grid[neighborY][neighborX] == '1') {
							union(y * width + x, neighborY * width + neighborX);
						}
					}
				}
			}
		}

		return islandCnt;
	}
}
