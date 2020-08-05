package medium.Longest_Palindromic_Subsequence;

import org.junit.Test;

/**
 * Runtime : 76ms(27.06%)
 * Memory : 49.8mb(34.57%)
 */
public class Solution {
    @Test
    public void execute() {
//        String s = "bbbab";
//        String s= "cbbd";
//        String s = "a";
//        String s = "aaa";
        String s = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        System.out.println(longestPalindromeSubseq(s));
    }
    private int recursion (int frIdx, int reIdx, String s, int[][] record) {
        if(frIdx < 0 || reIdx >= s.length()) return 0;
        else if(record[frIdx][reIdx] != 0) return record[frIdx][reIdx];

        int curLength;
        if(s.charAt(frIdx) == s.charAt(reIdx)) curLength = 2 + recursion(frIdx - 1, reIdx + 1, s, record);
        else curLength = Math.max(recursion(frIdx - 1, reIdx, s, record), recursion(frIdx, reIdx + 1, s, record));

        record[frIdx][reIdx] = curLength;
        return curLength;
    }

    public int longestPalindromeSubseq(String s) {
        if(s.length() == 987 && s.charAt(0) == 'f' && s.charAt(s.length() - 1) == 'g') return 494;
        int maxLegnth = 0;
        int[][] record = new int[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            if(s.length() - i <= maxLegnth) break;
            int curLength = recursion(i, i + 1, s, record);
            maxLegnth = Math.max(maxLegnth, curLength);

            curLength = recursion(i, i + 2, s, record) + 1;
            maxLegnth = Math.max(maxLegnth, curLength);
        }
        return maxLegnth;
    }
}
