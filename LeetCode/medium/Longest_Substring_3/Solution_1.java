package medium.Longest_Substring_3;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * 7ms(41.99%)
 * 44.53MB(46.18%)
 */
public class Solution_1 {
  @Test
  public void execute() {
    int result = lengthOfLongestSubstring("abba");
    System.out.println(result);
  }

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();
    Map<Character, Integer> idxSaveMap = new HashMap<>();
    int startIdx = 0;
    int longestSubStrLen = 1;

    idxSaveMap.put(s.charAt(0), 0);

    for (int i = 1; i < s.length(); i++) {
      char ch = s.charAt(i);
      Integer sameCharIdx = idxSaveMap.get(ch);
      if (sameCharIdx != null && startIdx <= sameCharIdx) {
        startIdx = sameCharIdx + 1;
      }
      idxSaveMap.put(ch, i);
      longestSubStrLen = Math.max(longestSubStrLen, i - startIdx + 1);
    }
    return longestSubStrLen;
  }
}
