package easy.Is_Subsequence;

import org.junit.Test;

/**
 * Runtime : 1ms(83.72%)
 * Memory : 39.1mb(20.86%)
 */
public class Solution {
    @Test
    public void execute() {
//        String s = "abc"; String t = "ahbgdc";
//        String s = "axc"; String t = "ahbgdc";
        String s = "ahbgdc"; String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        int targetIdx = 0;
        for(char source : t.toCharArray()) {
            if(s.charAt(targetIdx) == source) {
                targetIdx++;
                if(targetIdx == s.length()) return true;
            }
        }
        return false;
    }
}
