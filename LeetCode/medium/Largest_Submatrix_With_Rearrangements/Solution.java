package medium.Largest_Submatrix_With_Rearrangements;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int largestSubmatrix(int[][] matrix) {
		int maxSize = 0;
		for(int y = 0; y < matrix.length; y++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int x = 0; x < matrix[y].length; x++) if(matrix[y][x] == 1) queue.offer(x);
			int height = 1;
			while(!queue.isEmpty()) {
				int size = queue.size();
				maxSize = Math.max(maxSize, size * height++);
				for(int i = 0; i < size; i++) {
					int curX = queue.poll();
					if(matrix[y + height][curX] == 1) queue.offer(curX);
				}
			}
		}
		return maxSize;
	}
}
