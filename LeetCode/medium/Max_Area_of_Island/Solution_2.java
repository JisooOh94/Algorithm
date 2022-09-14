package medium.Max_Area_of_Island;

import java.util.Arrays;
import org.junit.Test;

/**
 * Runtime: 8 ms, faster than 14.64% of Java online submissions for Max Area of Island.
 * Memory Usage: 47.7 MB, less than 34.30% of Java online submissions for Max Area of Island.
 * Subject : union-find + path compression
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[][] grid = new int[][]{
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};

		System.out.println(maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;

		int[] parent = new int[height * width];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int curPos = y * width + x;
				parent[curPos] = grid[y][x] == 1 ? curPos : -1;
			}
		}

		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (grid[y][x] == 1) {
					int curPos = y * width + x;
					if(y - 1 >= 0 && grid[y - 1][x] == 1) union(curPos, curPos - width, parent);
					if(y + 1 < height && grid[y + 1][x] == 1) union(curPos, curPos + width, parent);
					if(x - 1 >= 0 && grid[y][x - 1] == 1) union(curPos, curPos - 1, parent);
					if(x + 1 < width && grid[y][x + 1] == 1) union(curPos, curPos + 1, parent);
				}
			}
		}

		int[] size = new int[width * height];
		for(int i = 0; i < width * height; i++) {
			if(parent[i] != -1) size[find(i, parent)]++;
		}
		Arrays.sort(size);
		return size[width * height - 1];
	}

	private void union(int source, int target, int[] parent) {
		int sourcePar = find(source, parent);
		int targetPar = find(target, parent);

		if(sourcePar != targetPar) parent[sourcePar] = targetPar;
	}

	private int find(int idx, int[] parent) {
		if(parent[idx] == idx) return idx;
		parent[idx] = find(parent[idx], parent);
		return parent[idx];
	}
}
