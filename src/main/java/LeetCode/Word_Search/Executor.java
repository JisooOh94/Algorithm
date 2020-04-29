package LeetCode.Word_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import LeetCode.Word_Ladder.Solution_2;
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
