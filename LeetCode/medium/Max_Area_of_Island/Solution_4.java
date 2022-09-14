package medium.Max_Area_of_Island;

import java.util.Arrays;
import org.junit.Test;

/**
 * Runtime: 12 ms, faster than 7.58% of Java online submissions for Max Area of Island.
 * Memory Usage: 49.9 MB, less than 8.19% of Java online submissions for Max Area of Island.
 * Subject : union-find + path compression + rank compression
 */
public class Solution_4 {
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
		int[] rank = new int[width * height];
		boolean islandExist = false;

		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (grid[y][x] == 1) {
					islandExist = true;
					int curPos = y * width + x;
					if(y - 1 >= 0 && grid[y - 1][x] == 1) union(curPos, curPos - width, size, rank, parent);
					if(y + 1 < height && grid[y + 1][x] == 1) union(curPos, curPos + width, size, rank, parent);
					if(x - 1 >= 0 && grid[y][x - 1] == 1) union(curPos, curPos - 1, size, rank, parent);
					if(x + 1 < width && grid[y][x + 1] == 1) union(curPos, curPos + 1, size, rank, parent);
				}
			}
		}

		Arrays.sort(size);
		return islandExist ? size[width * height - 1] + 1 : 0;
	}

	private void union(int source, int target, int[] size, int[] rank, Integer[] parent) {
		int sourcePar = find(source, parent);
		int targetPar = find(target, parent);

		if(sourcePar != targetPar) {
			if(rank[sourcePar] < rank[targetPar]) {
				parent[sourcePar] = targetPar;
				size[targetPar] += size[sourcePar] + 1;
			} else if(rank[targetPar] < rank[sourcePar]) {
				parent[targetPar] = sourcePar;
				size[sourcePar] += size[targetPar] + 1;
			} else {
				parent[targetPar] = sourcePar;
				size[sourcePar] += size[targetPar] + 1;
				rank[sourcePar]++;
			}
		}
	}

	private int find(int idx, Integer[] parent) {
		if(parent[idx] == null) return idx;
		parent[idx] = find(parent[idx], parent);
		return parent[idx];
	}
}
