package medium.Maximum_Value_after_Insertion;

/**
 * Runtime : 25ms(34.20%)
 * Memory : 74.3mb(6.69%)
 * Time Comlexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public String maxValue(String n, int x) {
		StringBuilder builder = new StringBuilder();
		if(n.charAt(0) == '-') {
			builder.append('-');
			for(int i = 1; i < n.length(); i++) {
				if(x < n.charAt(i) - '0') {
					builder.append(x);
					builder.append(n.substring(i));
					break;
				}
				builder.append(n.charAt(i));
			}
		} else {
			for(int i = 0; i < n.length(); i++) {
				if(n.charAt(i) - '0' < x) {
					builder.append(x);
					builder.append(n.substring(i));
					break;
				}
				builder.append(n.charAt(i));
			}
		}
		return builder.length() == n.length() ? builder.append(x).toString() : builder.toString();
	}
}
