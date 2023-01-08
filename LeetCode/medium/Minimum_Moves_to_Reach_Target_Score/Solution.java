package medium.Minimum_Moves_to_Reach_Target_Score;

/**
 * Runtime : 0ms(100%)
 * Memory : 39.1mb(88.33%)
 * Time Complexity : O(logn)
 */
public class Solution {
  public int minMoves(int target, int maxDoubles) {
    if(target == 1) return 0;
    else if(maxDoubles == 0) return target - 1;
    int moveCnt = 0;
    while(true) {
      moveCnt++;
      if(target % 2 == 0 && maxDoubles > 0) {
        target /= 2;
        maxDoubles--;
      } else {
        target--;
      }
      if(target == 1) break;
      if(maxDoubles == 0) {
        moveCnt += target - 1;
        break;
      }
    }
    return moveCnt;
  }
}
