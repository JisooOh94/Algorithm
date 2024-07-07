package medium.Longest_Substring_3;

import org.junit.Test;

/**
 * 3ms(90.31%)
 * 43.50MB(87.67%)
 */
public class Solution_2 {
  @Test
  public void execute() {
    int result = lengthOfLongestSubstring("aab");
    System.out.println(result);
  }
  private static final int CHAR_START_IDX = ' ';
  private static final int CHAR_END_IDX = '~';

  public int lengthOfLongestSubstring(String s) {
    Integer[] IDX_SAVE_ARR = new Integer[CHAR_END_IDX - CHAR_START_IDX + 1];
    if (s.length() == 0 || s.length() == 1) return s.length();

    int startIdx = 0;
    int longestSubStrLen = 1;

    IDX_SAVE_ARR[s.charAt(0) - CHAR_START_IDX] = 0;

    for (int i = 1; i < s.length(); i++) {
      char ch = s.charAt(i);
      Integer sameCharIdx = IDX_SAVE_ARR[ch  - CHAR_START_IDX];
      if (sameCharIdx != null && startIdx <= sameCharIdx) {
        startIdx = sameCharIdx + 1;
      }
      IDX_SAVE_ARR[ch - CHAR_START_IDX] = i;
      longestSubStrLen = Math.max(longestSubStrLen, i - startIdx + 1);
    }
    return longestSubStrLen;
  }
}
