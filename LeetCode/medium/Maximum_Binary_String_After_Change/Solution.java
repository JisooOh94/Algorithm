package medium.Maximum_Binary_String_After_Change;

/**
 *
 */
public class Solution {
	public String maximumBinaryString(String binary) {
		char[] str = binary.toCharArray();
		for(int i = 0; i < str.length - 1; i++) {
			if(str[i] == '0') {
				if(str[i + 1] == '0') str[i] = '1';
				else if(i + 2 < str.length && str[i + 1] == '1' && str[i + 2] == '0') {
					str[i] = '1';
					str[i + 2] = '1';
				}
			}
		}
		return new String(str);
	}
}
