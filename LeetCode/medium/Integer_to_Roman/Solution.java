package medium.Integer_to_Roman;

import util.Predicate;

public class Solution implements Predicate<String, Object> {
	public String test(Object... params) {
		return intToRoman((Integer) params[0]);
	}

	public String intToRoman(int num) {
		int rangeIdx = 0;
		int rangeNum[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String rangeStr[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

		String result = "";

		while(num != 0) {
			if(num - rangeNum[rangeIdx] >= 0) {
				num -= rangeNum[rangeIdx];
				result += rangeStr[rangeIdx];
			} else {
				rangeIdx++;
			}
		}

		return result;
	}
}
