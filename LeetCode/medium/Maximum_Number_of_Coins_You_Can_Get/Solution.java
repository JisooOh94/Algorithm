package medium.Maximum_Number_of_Coins_You_Can_Get;

import java.util.Arrays;
import org.junit.Test;

/**
 * Runtime : 27ms(61.24%)
 * Memory : 56.36mb(45.57%)
 * Time Complexity : O(n^2)
 */
public class Solution {
  @Test
  public void execute() {
    int[] piles = {2,4,1,2,7,8};
    System.out.println(maxCoins(piles));
  }

  public int maxCoins(int[] piles) {
    Arrays.sort(piles);

    int minIdx = 0;
    int maxIdx = piles.length - 1;

    int myCoinSum = 0;
    while (minIdx <= maxIdx) {
      myCoinSum += piles[maxIdx - 1];
      minIdx++;
      maxIdx-=2;
    }
    return myCoinSum;
  }
}
