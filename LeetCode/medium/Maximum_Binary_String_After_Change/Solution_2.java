package medium.Maximum_Binary_String_After_Change;

/**
 * Runtime : 27ms(94.08%)
 * Memory : 40mb(98.03%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution_2 {
	public String maximumBinaryString(String binary) {
		char[] str = binary.toCharArray();
		int curZero = binary.indexOf("0");
		for(int nextZero = curZero + 1; nextZero < str.length; nextZero++) {
			if(str[nextZero] == '0') {
				str[curZero] = '1';
				str[nextZero] = '1';
				str[++curZero] = '0';
			}
		}
		return new String(str);
	}
}
