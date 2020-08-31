package medium.Numbers_With_Same_Consecutive_Differences;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 11ms(12.45%)
 * Memory : 42.8mb(5.01%)
 */
public class Solution {
	@Test
	public void execute() {
//		int n = 9; int k = 1;
		int n = 2;
		int k = 0;
		int[] result = numsSameConsecDiff(n, k);

		for (int num : result) System.out.print(num + " ");
	}

	private List<Integer> recursion(int curIdx, int curNum, int gap, List<Integer>[][] record) {
		if (curIdx == 0) return Arrays.asList(curNum);
		else if (record[curIdx][curNum] != null) return record[curIdx][curNum];

		List<Integer> resultList = new LinkedList<>();

		if (curNum + gap < 10) resultList.addAll(recursion(curIdx - 1, curNum + gap, gap, record));
		if (curNum - gap >= 0) resultList.addAll(recursion(curIdx - 1, curNum - gap, gap, record));

		for (int i = 0; i < resultList.size(); i++) {
			resultList.set(i, resultList.get(i) + curNum * (int) Math.pow(10, curIdx));
		}

		return resultList;
	}

	public int[] numsSameConsecDiff(int N, int K) {
		List<Integer> resultList = new LinkedList<>();

		if (K == 0) {
			for (int i = 1; i <= 9; i++) {
				int num = i;
				for (int j = 1; j < N; j++) {
					num += i * Math.pow(10, j);
				}
				resultList.add(num);
			}

			if(N == 1) resultList.add(0);
		} else {

			LinkedList<Integer>[][] record = new LinkedList[N][10];

			for (int i = 1; i <= 9; i++) {
				resultList.addAll(recursion(N - 1, i, K, record));
			}

			if (N == 1) resultList.add(0);
		}

		int[] resultArr = new int[resultList.size()];

		int idx = 0;
		for (Iterator<Integer> iter = resultList.iterator(); iter.hasNext(); ) {
			resultArr[idx++] = iter.next();
		}
		return resultArr;
	}
}
