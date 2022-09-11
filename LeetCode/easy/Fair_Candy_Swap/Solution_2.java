package easy.Fair_Candy_Swap;

import java.util.HashSet;
import java.util.Set;

/**
 * Runtime: 17 ms, faster than 83.25% of Java online submissions for Fair Candy Swap.
 * Memory Usage: 45.3 MB, less than 86.43% of Java online submissions for Fair Candy Swap.
 * Time Complexity : O(n)
 */
public class Solution_2 {
  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int aSum = 0;
    int bSum = 0;
    Set<Integer> aSet = new HashSet<>();
    Set<Integer> bSet = new HashSet<>();

    for(int a : aliceSizes) {
      aSum += a;
      aSet.add(a);
    }

    for(int b : bobSizes) {
      bSum += b;
      bSet.add(b);
    }

    int needGap = (bSum - aSum) / 2;

    for (int a : aSet) {
      if (bSet.contains(a + needGap)) {
        return new int[]{a, a + needGap};
      }
    }
    return null;
  }
}
