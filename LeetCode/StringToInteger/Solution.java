package StringToInteger;

import util.Predicate;

/**
 * Time Complexity : O(n)
 */
public class Solution implements Predicate<Integer, Object> {
	private static final int INT_MAX = 2147483647;
	private static final int INT_MIN = -2147483648;

	public Integer test(Object... params) {
		return myAtoi((String)params[0]);
	}

	public int myAtoi(String str) {
		if(str == null) {
			return 0;
		}

		boolean isStart = false;
		long num = 0;
		int sign = 1;

		for(int i = 0; i < str.length(); i++) {
			char word = str.charAt(i);
			if(isStart) {
				if('0' <= word && word <= '9') {
					num = num * 10 + (word - 48);

					if(sign == 1 && num >= INT_MAX) {
						return INT_MAX;
					} else if(sign == -1 && num * sign <= INT_MIN) {
						return INT_MIN;
					}
				} else {
					break;
				}
			} else {
				if(word == ' ') {
					continue;
				} else if(word == '+' || word == '-') {
					if(word == '-') {
						sign = -1;
					}
					isStart = true;
				} else if('0' <= word && word <= '9') {
					num = word - 48;
					isStart = true;
				} else {
					return 0;
				}
			}
		}

		return (int)num * sign;
	}
}
