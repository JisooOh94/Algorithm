package medium.Ternary_Expression_Parser;

/**
 * Runtime : 1ms(85.37%)
 * Memory : 39mb(12.20%)
 */
public class Solution {
	private int[] recursion(int startIdx, char[] str) {
		if(startIdx + 1 == str.length || str[startIdx + 1] != '?') return new int[]{startIdx, str[startIdx]};

		int[] leftResult = recursion(startIdx + 2, str);
		int[] rightResult = recursion(leftResult[0] + 2, str);

		if(str[startIdx] == 'T') {
			leftResult[0] = rightResult[0];
			return leftResult;
		} else {
			return rightResult;
		}
	}
	public String parseTernary(String expression) {
		int[] result = recursion(0, expression.toCharArray());
		return String.valueOf((char)result[1]);
	}
}
