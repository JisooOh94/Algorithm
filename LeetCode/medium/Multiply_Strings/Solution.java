package medium.Multiply_Strings;

import util.Predicate;

/**
 * Runtime : 7ms(33.61%)
 * Memory : 38.2mb(23.33%)
 */
public class Solution implements Predicate<String, Object> {
	private static final char CHAR_PARSER = '0';

	public String test(Object... params) {
		return multiply((String)params[0], (String)params[1]);
	}

	public String multiply(String num_1, String num_2) {
		if(num_1.equals("0") || num_2.equals("0")) return "0";
		else if(num_1 == "1") return num_2;
		else if(num_2 == "1") return num_1;

		StringBuilder resultStr = new StringBuilder();

		for(int num_1_idx = 0; num_1_idx < num_1.length(); num_1_idx++) {
			int up = 0;

			for(int num_2_idx = 0; num_2_idx < num_2.length(); num_2_idx++) {
				int source = (num_1.charAt(num_1.length() - (num_1_idx + 1)) - CHAR_PARSER) * (num_2.charAt(num_2.length() - (num_2_idx + 1)) - CHAR_PARSER);
				int sum = source + up;

				if(num_1_idx + num_2_idx < resultStr.length()) {
					int target = resultStr.charAt(num_1_idx + num_2_idx) - CHAR_PARSER;
					sum += target;
					resultStr.setCharAt(num_1_idx + num_2_idx, (char)(sum % 10 + CHAR_PARSER));
				} else {
					resultStr.append((char)(sum % 10 + CHAR_PARSER));
				}

				up = sum / 10;
			}
			if(up != 0) resultStr.append((char)(up + CHAR_PARSER));
		}

		return resultStr.reverse().toString();
	}
}
