package easy.Set_Mismatch;

import java.util.Arrays;
import org.junit.Test;

/*
Runtime: 36 ms, faster than 12.32% of Java online submissions for Set Mismatch.
Memory Usage: 54.5 MB, less than 57.65% of Java online submissions for Set Mismatch.
Subject : brute force
Time complexity : O(n)
 */
public class Solution {
  @Test
  public void execute() {
    int[] nums = new int[]{1,5,3,2,2,7,6,4,8,9};
    int[] result = findErrorNums(nums);
    int a = 0;
  }
  public int[] findErrorNums(int[] nums) {
    Arrays.sort(nums);
    int[] result = new int[2];
    int abnormalSum = 0;
    int normalSum = 0;
    //find duplicated
    for(int i = 0; i < nums.length; i++) {
      if(i != 0 && nums[i] == nums[i - 1]) result[0] = nums[i];
      abnormalSum += nums[i];
      normalSum += i + 1;
    }
    result[1] = normalSum - (abnormalSum - result[0]);

    return result;
  }

}
