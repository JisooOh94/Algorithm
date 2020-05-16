package Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Best {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	//1. '(' 를 추가할수 있는 제한은 추가된 '('의 개수가 n개를 넘지 않는것이다.
	//2. ')'를 추가할 수 있는 제한은 추가된 ')'의 개수가 추가된 '('의 개수를 넘지 않는것이다.	>> ()) 불가능
	//3. 문자열의 첫 시작은 항상 '(' 이다.
	//위 3가지 조건만 만족하면 자동으로 마지막 문자는 항상 ')'이 되고
	//하나의 문자열에 대해 '('를 추가하는경우와 ')'를 추가하는경우를 모두 수행하므로
	//재귀적으로 수행시, '('와 ')'가 잘 섞인 모든 경우의 수가 나온다...
	//진짜 천재인가..
	public void backtrack(List<String> list, String str, int open, int close, int max) {
		if (str.length() == max * 2) {
			list.add(str);
			return;
		}
		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}
}
