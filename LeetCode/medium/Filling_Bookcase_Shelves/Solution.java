package medium.Filling_Bookcase_Shelves;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.4mb(14.81%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] books = new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
		int shelfWidth = 4;
		System.out.println(minHeightShelves(books, shelfWidth));
	}
	private int recursion(int bookIdx, int[][] books, int shelveWidth, int[] record) {
		if(bookIdx == books.length) return 0;
		else if(record[bookIdx] != 0) return record[bookIdx];

		int minHeight = 999999;
		int curHeight = 0;
		int curWidth = 0;

		for(int i = bookIdx; i < books.length; i++) {
			curWidth += books[i][0];
			if(curWidth > shelveWidth) break;

			curHeight = Math.max(curHeight, books[i][1]);
			minHeight = Math.min(minHeight, curHeight + recursion(i + 1, books, shelveWidth, record));
		}
		record[bookIdx] = minHeight;
		return minHeight;
	}
	public int minHeightShelves(int[][] books, int shelf_width) {
		int[] record = new int[books.length];
		return recursion(0, books, shelf_width, record);
	}
}
