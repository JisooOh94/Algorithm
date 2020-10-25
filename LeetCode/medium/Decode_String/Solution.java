package medium.Decode_String;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.4mb(8.20%)
 */
public class Solution {
	@Test
	public void execute() {
//		String s = "3[a]2[bc]";
		String s = "3[a2[c]]";
		System.out.println(decodeString(s));
	}
	private int nextIdx = 0;
	private String recursion(int startIdx, String s) {
		StringBuilder builder = new StringBuilder();
		int idx = startIdx;
		while(idx < s.length() && s.charAt(idx) != ']') {
			if('1' <= s.charAt(idx) && s.charAt(idx) <= '9') {
				StringBuilder numBuilder = new StringBuilder();
				for(; s.charAt(idx) != '['; idx++) numBuilder.append(s.charAt(idx));

				int cnt = Integer.parseInt(numBuilder.toString());
				String str = recursion(++idx, s);

				for(int j = 0; j < cnt; j++) builder.append(str);
				idx = nextIdx;
			} else {
				builder.append(s.charAt(idx++));
			}
		}
		nextIdx = idx + 1;
		return builder.toString();
	}
	public String decodeString(String s) {
		return recursion(0, s);
	}
}
