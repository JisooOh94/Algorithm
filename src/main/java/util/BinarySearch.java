package util;

public class BinarySearch {
	private BinarySearch() {
		throw new AssertionError();
	}

	private static int binarySearch(int[] arr, int target, int left, int right) {
		if(left == right) {
			if(arr.length == right) return (left + 1) * -1;
			else if(target < arr[left]) return (left + 1) * -1;
			else return (left + 2) * -1;
		}

		int m = (left + right) / 2;

		if(arr[m] == target) return m;
		else if(target < arr[m]) return binarySearch(arr, target, left, m);
		else return binarySearch(arr,target, m + 1, right);
	}

	private static int verticalBinarySearch(int[][] arr, int target, int left, int right) {
		if(left == right) {
			if(arr.length == right) return (left + 1) * -1;
			else if(target < arr[left][0]) return (left + 1) * -1;
			else return (left + 2) * -1;
		}

		int m = (left + right) / 2;

		if(arr[m][0] == target) return m;
		else if(target < arr[m][0]) return verticalBinarySearch(arr, target, left, m);
		else return verticalBinarySearch(arr,target, m + 1, right);
	}
}
