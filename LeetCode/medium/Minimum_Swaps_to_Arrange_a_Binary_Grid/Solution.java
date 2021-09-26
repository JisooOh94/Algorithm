package medium.Minimum_Swaps_to_Arrange_a_Binary_Grid;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 6ms(8.14%)
 * Memory : 65.6mb(8.14%)
 * Time Complexity : O(n^2)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] grid = new int[][]{{0,0,1},{1,1,0},{1,0,0}};
		int[][] grid = new int[][]{{0,0},{0,1}};

		System.out.println(minSwaps(grid));
	}
	private static final int IDX = 0;
	private static final int LEN = 1;

	public int minSwaps(int[][] grid) {
		int swapCnt = 0;

		LinkedList<int[]> validRows = new LinkedList<>();
		for(int y = 0; y < grid.length; y++) {
			int validCnt = 0;
			for(int x = grid.length - 1; 0 <= x; x--) {
				if(grid[y][x] == 1 || x == 0) {
					if(validCnt != 0) validRows.add(new int[]{y, validCnt});
					break;
				}
				validCnt++;
			}
		}

		for(int y = 0; y < grid.length - 1; y++) {
			int needLen = grid.length - 1 - y;
			Iterator<int[]> targetRowIter = null;
			int[] targetRow = null;
			for(Iterator<int[]> iter = validRows.iterator(); iter.hasNext();) {
				int[] row = iter.next();
				if(row[LEN] >= needLen) {
					targetRowIter = iter;
					targetRow = row;
					break;
				}
				row[IDX]++;
			}

			if(targetRowIter == null) return -1;

			if(targetRow[IDX] == y) validRows.removeFirst();
			else {
				targetRowIter.remove();
				swapCnt += targetRow[IDX] - y;
			}
		}
		return swapCnt;
	}
}
