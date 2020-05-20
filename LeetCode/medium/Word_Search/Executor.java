package medium.Word_Search;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
//		char[][] board = new char[][]{
//				{'A', 'B', 'C', 'E'},
//				{'S', 'F', 'C', 'S'},
//				{'A', 'D', 'E', 'E'}
//		};
		char[][] board = new char[][]{
				{'C','A','A'},
				{'A','A','A'},
				{'B','C','D'}
		};

		//String word = "ABCCED";
		//String word = "SEE";
		//String word = "ABCB";
		String word = "AAB";
		PerformanceUtil.calcPerformance(new Solution(), board, word);
	}
}
