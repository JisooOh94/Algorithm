package medium.Largest_Submatrix_With_Rearrangements;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime ; 8ms(54.79%)
 * Memory : 62.4mb(37.16%)
 * Time Complexity : O(n)
 * Subject : Greedy
 */
public class Solution_2 {
	public int largestSubmatrix(int[][] matrix) {
		for(int x = 0; x < matrix[0].length; x++) {
			for(int y = 1; y < matrix.length; y++) {
				if(matrix[y][x] == 1) matrix[y][x] = matrix[y - 1][x] + 1;
			}
		}

		int maxSize = 0;
		for(int y = 0; y < matrix.length; y++) {
			Arrays.sort(matrix[y]);
			for(int x = matrix[0].length - 1; 0 <= x; x--) {
				if(matrix[y][x] == 0) break;
				maxSize = Math.max(maxSize, matrix[y][x] * (matrix[0].length - x));
			}
		}

		return maxSize;
	}
}
