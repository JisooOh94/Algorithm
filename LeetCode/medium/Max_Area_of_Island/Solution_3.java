package medium.Max_Area_of_Island;

import java.util.Arrays;
import org.junit.Test;

/**
 * Runtime: 12 ms, faster than 7.58% of Java online submissions for Max Area of Island.
 * Memory Usage: 48.8 MB, less than 14.00% of Java online submissions for Max Area of Island.
 * Subject : union-find + path compression
 */
public class Solution_3 {
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

		Integer[] parent = new Integer[height * width];
		int[] size = new int[width * height];
		boolean islandExist = false;

		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (grid[y][x] == 1) {
					islandExist = true;
					int curPos = y * width + x;
					if(y - 1 >= 0 && grid[y - 1][x] == 1) union(curPos, curPos - width, size, parent);
					if(y + 1 < height && grid[y + 1][x] == 1) union(curPos, curPos + width, size, parent);
					if(x - 1 >= 0 && grid[y][x - 1] == 1) union(curPos, curPos - 1, size, parent);
					if(x + 1 < width && grid[y][x + 1] == 1) union(curPos, curPos + 1, size, parent);
				}
			}
		}

		Arrays.sort(size);
		return islandExist ? size[width * height - 1] + 1 : 0;
	}

	private void union(int source, int target, int[] size, Integer[] parent) {
		int sourcePar = find(source, parent);
		int targetPar = find(target, parent);

		if(sourcePar != targetPar) {
			size[sourcePar] += size[targetPar] + 1;
			parent[targetPar] = sourcePar;
		}
	}

	private int find(int idx, Integer[] parent) {
		if(parent[idx] == null) return idx;
		parent[idx] = find(parent[idx], parent);
		return parent[idx];
	}
}
