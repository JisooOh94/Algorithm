package medium.Maximum_Number_of_Coins_You_Can_Get;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

/**
 * Runtime : 95ms
 * Memory : 56.52mb
 */
public class Solution_2 {
  @Test
  public void execute() {
    int[] piles = {2,4,1,2,7,8};
    System.out.println(maxCoins(piles));
  }

  public int maxCoins(int[] piles) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < piles.length; i++) {
      queue.offer(piles[i]);
    }

    int pilesCnt = piles.length / 3;
    int myCoinSum = 0;

    for(int i = 0; i < pilesCnt; i++) {
      queue.poll();
      myCoinSum += queue.poll();
    }
    return myCoinSum;
  }
}
