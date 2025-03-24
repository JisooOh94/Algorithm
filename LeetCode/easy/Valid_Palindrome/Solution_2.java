package easy.Valid_Palindrome;

import org.junit.Test;

/**
 * Time Complexity : O(n)
    * 2ms Beats 99.05%
 * Space Complexity : O(1)
    * 43.30MB Beats 58.50%
 */
public class Solution_2 {

    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int frontIdx = 0;
        int rearIdx = s.length();

        while (frontIdx < rearIdx) {
            if (isAlphaNumeric(s.charAt(frontIdx))) {
                char frontChar = getLowerCaseCharacter(s.charAt(frontIdx));

                while (frontIdx < --rearIdx) {
                    if (isAlphaNumeric(s.charAt(rearIdx))) {
                        char rearChar = getLowerCaseCharacter(s.charAt(rearIdx));
                        if (frontChar != rearChar) {
                            return false;
                        }
                        break;
                    }
                }
            }
            frontIdx++;
        }

        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        return ('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    private char getLowerCaseCharacter(char ch) {
        if ('A' <= ch && ch <= 'Z') {
            return (char)(ch - ('A' - 'a'));
        }
        return ch;
    }
}
