package medium.Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 31ms(37.20%)
 * Memory : 39.3mb(5.24%)
 */
public class Solution_2 {
	@Test
	public void execute() {
//		int[][] stones = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		int[][] stones = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
//		int[][] stones = new int[][]{{0,0}};
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

		boolean[] xVisited = new boolean[xMax + 1];
		boolean[] yVisited = new boolean[yMax + 1];

		Integer[] parent = new Integer[stones.length + 1];
		for(int i = 0; i < stones.length; i++) {
			if(!xVisited[stones[i][0]]) {
				for(int j = i + 1; j < stones.length; j++) {
					if(stones[j][0] == stones[i][0]) {
						int parentIdx = getParent(i, parent);
						int childIdx = getParent(j, parent);

						if(parentIdx != childIdx) {
							parent[childIdx] = parentIdx;
							connected++;
						}
					}
				}
				xVisited[stones[i][0]] = true;
			}

			if(!yVisited[stones[i][1]]) {
				for(int j = i + 1; j < stones.length; j++) {
					if(stones[j][1] == stones[i][1]) {
						int parentIdx = getParent(i, parent);
						int childIdx = getParent(j, parent);

						if(parentIdx != childIdx) {
							parent[childIdx] = parentIdx;
							connected++;
						}
					}
				}
				yVisited[stones[i][1]] = true;
			}
		}

		return connected;
	}
}
