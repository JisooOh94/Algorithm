package Generate_Parentheses;

import java.util.LinkedList;
import java.util.List;

import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 39.1mb(24.51%)
 */
public class Solution implements Predicate<List<String>, Object> {
	public List<String> test(Object... params) {
		return generateParenthesis((int)params[0]);
	}

	private static final char OPENER = '(';
	private static final char CLOSER = ')';

	private void recursion(int from, int to, int openerCnt, char[] charSeq, List<String> resultList) {
		if(openerCnt == to - from) {
			for(int i = from + 1; i <= to; i++) {
				charSeq[i] = CLOSER;
			}
			resultList.add(new String(charSeq));
			return;
		} else if(to - from == 1) {
			resultList.add(new String(charSeq));
			return;
		}

		charSeq[from + 1] = OPENER;
		recursion(from + 1, to, openerCnt + 1, charSeq, resultList);

		for(int i = 0; i < openerCnt; i++) {
			charSeq[from + 1 + i] = CLOSER;
			charSeq[from + 2 + i] = OPENER;
			recursion(from + 2 + i, to, openerCnt - i, charSeq, resultList);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> resultList = new LinkedList<>();

		if (n == 0) {
			resultList = null;
		} else if (n == 1){
			resultList.add("()");
		} else {
			char[] charSeq = new char[n * 2];
			charSeq[0] = OPENER;
			recursion(0, n * 2 - 1, 1, charSeq, resultList);
		}

		return resultList;
	}
}
