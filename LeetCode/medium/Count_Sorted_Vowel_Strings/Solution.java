package medium.Count_Sorted_Vowel_Strings;

import org.junit.Test;

/**
 * Runtime : 0ms (100%)
 * Memory : 39.69mb
 */
public class Solution {

  @Test
  public void execute() {
    int n = 33;
    int result = countVowelStrings(n);
    System.out.println("Result : " + result);
  }

  private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

  private int recursion(int strLen, int maxLen, int charIdx, Integer[][] record) {
    if (strLen == maxLen) return 1;
    else if (record[charIdx][strLen] != null) return record[charIdx][strLen];

    int possibleChildStrsCount = 0;
    for (int i = charIdx; i < VOWELS.length; i++) {
      possibleChildStrsCount += recursion(strLen + 1, maxLen, i, record);
    }

    record[charIdx][strLen] = possibleChildStrsCount;

    return possibleChildStrsCount;
  }

  public int countVowelStrings(int n) {
    if (n == 1) return VOWELS.length;

    Integer[][] record = new Integer[VOWELS.length][n];

    return recursion(0, n, 0, record);
  }
}
