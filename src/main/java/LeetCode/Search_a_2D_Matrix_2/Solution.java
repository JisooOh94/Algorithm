package LeetCode.Search_a_2D_Matrix_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.Predicate;

/**
 * Runtime : 0ms(100.0%)
 * Memory : 40mb(5.68%)
 */
public class Solution implements Predicate<Boolean, Object> {
	public Boolean test(Object... params) {
		return searchMatrix((int[][])params[0], (int)params[1]);
	}

	private int verticalBinarySearch(int[][] arr, int target, int left, int right, int idx) {
		if(left == right) {
			if(arr.length == right) return (left + 1) * -1;
			else if(target < arr[left][idx]) return (left + 1) * -1;
			else return (left + 2) * -1;
		}

		int m = (left + right) / 2;

		if(arr[m][idx] == target) return m;
		else if(target < arr[m][idx]) return verticalBinarySearch(arr, target, left, m, idx);
		else return verticalBinarySearch(arr,target, m + 1, right, idx);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		else if(matrix.length == 1) return Arrays.binarySearch(matrix[0], 0, matrix[0].length, target) >= 0;
		else if(matrix[0].length == 1) return verticalBinarySearch(matrix, target, 0, matrix.length, 0) >= 0;
		//vertical min search
		int verticalMinIdx = verticalBinarySearch(matrix, target, 0, matrix.length, 0);
		if(verticalMinIdx >= 0) return true;
		verticalMinIdx = (verticalMinIdx * -1) - 2;
		if(verticalMinIdx < 0) return false;

		//horizontal min search
		int horizontalMinIdx = Arrays.binarySearch(matrix[0], 0, matrix[0].length, target);
		if(horizontalMinIdx >= 0) return true;
		horizontalMinIdx = horizontalMinIdx * -1 - 2;
		if(horizontalMinIdx < 0) return false;

		//vertical max search
		int verticalMaxIdx = verticalBinarySearch(matrix, target, 0, verticalMinIdx + 1, horizontalMinIdx);
		if(verticalMaxIdx >= 0) return true;
		verticalMaxIdx = verticalMaxIdx * -1 - 1;
		if(verticalMinIdx <= verticalMaxIdx) return false;

		int horizontalMaxIdx = Arrays.binarySearch(matrix[verticalMaxIdx], 0, horizontalMinIdx + 1, target);
		if(horizontalMaxIdx >= 0) return true;
		horizontalMaxIdx = horizontalMaxIdx * -1 -1;
		if(horizontalMinIdx <= horizontalMaxIdx) return false;

		for(int i = verticalMaxIdx; i <= verticalMinIdx; i++) {
			if(Arrays.binarySearch(matrix[i], horizontalMaxIdx, horizontalMinIdx, target) >= 0) return true;
		}
		return false;
	}

}
