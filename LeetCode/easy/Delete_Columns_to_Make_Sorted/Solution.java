package easy.Delete_Columns_to_Make_Sorted;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 4ms(99.26%)
 * Memory : 40.1mb(8.33%)
 */
public class Solution implements Predicate<Integer, Object> {
	@Test
	public void execute() {
//		String[] pararm = new String[]{"cba","daf","ghi"};
//		String[] pararm = new String[]{"a","b"};
		String[] pararm = new String[]{"zyx","wvu","tsr"};
		PerformanceUtil.calcPerformance(new Solution(), pararm);
	}

	@Override
	public Integer test(Object... params) {
		return minDeletionSize((String[])params);
	}

	public int minDeletionSize(String[] A) {
		if(A.length == 1) return 0;

		int colLength = A[0].length();
		int deletionSize = 0;

		for(int x = 0; x < colLength; x++) {
			char prevChar = A[0].charAt(x);
			char lastChar = A[A.length - 1].charAt(x);

			for(int y = 1; y < A.length; y++) {
				char curChar = A[y].charAt(x);
				if(curChar < prevChar ||  lastChar < curChar) {
					deletionSize++;
					break;
				}
				prevChar = curChar;
			}
		}

		return deletionSize;
	}
}
