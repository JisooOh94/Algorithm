package LeetCode.Spiral_Matrix;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.4mb(5.21%)
 */
public class Solution implements Predicate<List<Integer>, Object> {
	public List<Integer> test(Object... params) {
		return spiralOrder((int[][])params[0]);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return Collections.EMPTY_LIST;
		}

		List<Integer> resultList = new LinkedList<>();
		int height = matrix.length;
		int width = matrix[0].length;
		int count = height * width;

		if(height == 1) {
			for(Integer num : matrix[0]) {
				resultList.add(num);
			}

			return resultList;
		} else if(width == 1) {
			for(int i = 0; i < height; i++) {
				resultList.add(matrix[i][0]);
			}

			return resultList;
		}

		recursion(matrix, resultList, count, 0, height - 1, 0, width - 1);

		return resultList;
	}

	private void recursion(int[][] matrix, List<Integer> resultList, int count, int t, int b, int l, int r) {
		if(resultList.size() == count) {
			return;
		}

		for(int i = l; i <= r; i++) {
			resultList.add(matrix[t][i]);
		}

		for(int i = t + 1; i <= b; i++) {
			resultList.add(matrix[i][r]);
		}

		if(resultList.size() == count) {
			return;
		}

		for(int i = r - 1; l <= i; i--) {
			resultList.add(matrix[b][i]);
		}

		for(int i = b - 1; t < i; i--) {
			resultList.add(matrix[i][l]);
		}

		recursion(matrix, resultList, count, t + 1, b - 1, l + 1, r - 1);
	}
}
