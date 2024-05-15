package medium.Partition_Array_for_Maximum_Sum;

import org.junit.Test;

/**
 * Runtime : 6ms(92.97%)
 * Memory : 41.98mb(59.60%)
 */
public class Solution {

  @Test
  public void execute() {
    int[] arr = new int[]{1,15,7,9,2,5,10};
    int k = 3;
    int result = maxSumAfterPartitioning(arr, k);
    System.out.println(result);
  }

  private int recursion(int idx, int k, int[] arr, Integer[] record) {
    if (idx == arr.length) return 0;
    if (idx == arr.length - 1) return arr[idx];
    if (record[idx] != null) return record[idx];

    int maxSum = 0;
    int maxVal = 0;
    for (int i = idx; i < Math.min(idx + k, arr.length); i++) {
      maxVal = Math.max(maxVal, arr[i]);
      int partitionSum = maxVal * (i - idx + 1);
      int afterPartitionsSum = recursion(i + 1, k, arr, record);
      maxSum = Math.max(maxSum, partitionSum + afterPartitionsSum);
    }

    record[idx] = maxSum;

    return maxSum;
  }


  public int maxSumAfterPartitioning(int[] arr, int k) {
    Integer[] record = new Integer[arr.length];
    return recursion(0, k, arr, record);
  }

}
