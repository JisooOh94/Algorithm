package medium.Unique_Substrings_in_Wraparound_String;

import org.junit.Test;

public class Solution {

	@Test
	public void execute() {
		String p = "ababdedsfeabcge";
		System.out.println(findSubstringInWraproundString(p));
	}

	private static final int CHAR2INT = 97;
	private static final int CHAR_LEN = 26;

	private int recursion(int curIdx, int prevChar, char[] str, Integer[][] record) {
		if(curIdx == str.length) return 0;
		else if(record[curIdx][prevChar] != null) return record[curIdx][prevChar];

		int cnt = 0;
		if(prevChar + 1 == str[curIdx] - CHAR2INT + 1) {
			cnt = 1 + recursion(curIdx + 1, str[curIdx] - CHAR2INT + 1, str, record);
		} else {
			cnt = recursion(curIdx + 1, prevChar, str, record);
		}

		record[curIdx][prevChar] = cnt;
		return cnt;
	}

	public int findSubstringInWraproundString(String p) {
		char[] str = p.toCharArray();
		boolean[] visited = new boolean[CHAR_LEN + 1];
		Integer[][] record = new Integer[str.length][CHAR_LEN + 1];

		int result = 0;
		for(int i = 0; i < str.length; i++) {
			int curChar = str[i] - CHAR2INT + 1;
			if(!visited[curChar]){
				visited[curChar] = true;
				result += recursion(i, curChar - 1, str, record);
			}
		}
		return result;
	}
}
