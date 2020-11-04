package medium.Most_Stones_Removed_with_Same_Row_or_Column;

import org.junit.Test;

/**
 * Runtime : 3ms(99.56%%)
 * Memory : 39.3mb(5.24%)
 */
public class Solution_3 {
	@Test
	public void execute() {
//		int[][] stones = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		int[][] stones = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
//		int[][] stones = new int[][]{{0,0}};
//		int[][] stones = new int[][]{{0,1}, {1,0}};
		System.out.println(removeStones(stones));
	}
	private int getParent(int cur, Integer[] parent) {
		while(parent[cur] != null) cur = parent[cur];
		return cur;
	}

	public int removeStones(int[][] stones) {
		int connected = 0;
		int xMax = 0, yMax = 0;
		for(int[] stone : stones) {
			xMax = Math.max(xMax, stone[0]);
			yMax = Math.max(yMax, stone[1]);
		}

		Integer[] xParent = new Integer[xMax + 1];
		Integer[] yParent = new Integer[yMax + 1];
		Integer[] parent = new Integer[stones.length + 1];

		for (int i = 0; i < stones.length; i++) {
			if (xParent[stones[i][0]] != null) {
				int parentIdx = getParent(xParent[stones[i][0]], parent);
				int childIdx = getParent(i, parent);

				if (parentIdx != childIdx) {
					parent[childIdx] = parentIdx;
					connected++;
				}
			} else {
				xParent[stones[i][0]] = i;
			}
			if (yParent[stones[i][1]] != null) {
				int parentIdx = getParent(yParent[stones[i][1]], parent);
				int childIdx = getParent(i, parent);

				if (parentIdx != childIdx) {
					parent[childIdx] = parentIdx;
					connected++;
				}
			} else {
				yParent[stones[i][1]] = i;
			}
		}

		return connected;
	}
}
