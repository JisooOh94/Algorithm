package medium.Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers;

/**
 * Runtime : 4ms(94.04%)
 * Memory : 39.4mb(80.28%)
 * Time Complexity : O(n)
 * Topic : Greedy
 */
public class Solution {
	public int minPartitions(String n) {
		char maxCh = '0';
		for(char ch : n.toCharArray()) {
			maxCh = (char)Math.max((int)maxCh, (int)ch);
		}
		return (int)maxCh - (int)'0';
	}
}
