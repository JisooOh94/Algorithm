package medium.Filling_Bookcase_Shelves;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.4mb(14.81%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[][] books = new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
		int shelfWidth = 4;
		System.out.println(minHeightShelves(books, shelfWidth));
	}

	public int minHeightShelves(int[][] books, int shelf_width) {
		int[] record = new int[books.length + 1];

		record[0] = 0;

		for (int i = 1; i <= books.length; i++) {
			int width = books[i-1][0];
			int height = books[i-1][1];
			record[i] = record[i-1] + height;

			for (int j = i - 2; j > 0; j--) {
				width += books[j][0];
				if(shelf_width < width) break;

				height = Math.max(height, books[j][1]);
				record[i] = Math.min(record[i], record[j] + height);
			}
		}
		return record[books.length];
	}
}
